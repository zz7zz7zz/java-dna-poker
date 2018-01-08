package com.poker.game;

import java.util.Arrays;
import java.util.LinkedList;

import com.open.net.client.GClient;
import com.open.net.client.impl.tcp.nio.NioClient;
import com.open.net.client.message.Message;
import com.open.net.client.object.AbstractClient;
import com.open.net.client.object.AbstractClientMessageProcessor;
import com.open.net.client.object.ClientConfig;
import com.open.net.client.object.IConnectListener;
import com.open.net.client.object.TcpAddress;
import com.open.net.server.object.ArgsConfig;
import com.open.net.server.object.ServerLog;
import com.open.net.server.object.ServerLog.LogListener;
import com.open.net.server.utils.NetUtil;
import com.open.util.log.Logger;
import com.open.util.log.base.LogConfig;
import com.poker.base.ServerIds;
import com.poker.cmd.AllocatorCmd;
import com.poker.common.config.Config;
import com.poker.data.DataPacket;
import com.poker.handler.MessageHandler;
import com.poker.protocols.Dispatcher;
import com.poker.protocols.Monitor;


/**
 * author       :   long
 * created on   :   2017/11/30
 * description  :  服务器入口
 */

public class Main {

    public static void main(String [] args){
    	
        //----------------------------------------- 一、配置初始化 ------------------------------------------
    	//1.1 服务器配置初始化:解析命令行参数
    	libArgsConfig = new ArgsConfig();
    	libArgsConfig.initArgsConfig(args);
    	libArgsConfig.server_type = ServerIds.SERVER_GAME;
        
        //1.3 服务器配置初始化:作为客户端配置
        ClientConfig libClientConfig = new ClientConfig();
        libClientConfig.initFileConfig("./conf/lib.client.config");
        GClient.init(libClientConfig);
        
        //1.3 日志配置初始化
        LogConfig libLogConfig = Logger.init("./conf/lib.log.config",libArgsConfig.id);
        Logger.addFilterTraceElement(ServerLog.class.getName());
        Logger.addFilterTraceElement(mLogListener.getClass().getName());
        
        //1.4 业务配置初始化
        mConfig = new Config();
        mConfig.initFileConfig("./conf/server.config");
        
        Logger.v("libArgsConfig: "+ libArgsConfig.toString()+"\r\n");
        Logger.v("libClientConfig: "+ libClientConfig.toString()+"\r\n");
        Logger.v("libLogConfig: "+ libLogConfig.toString()+"\r\n");
        Logger.v("mConfig: "+ mConfig.toString()+"\r\n");
        
        //----------------------------------------- 二、注册到关联服务器 ---------------------------------------
        register_monitor(mConfig);//注册到服务监听器
    	register_dispatcher(mConfig);//注册到Dispatcher
    	
        //----------------------------------------- 三、服务器初始化 ------------------------------------------
    	while(true){
    		try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
    	}
        //----------------------------------------- 四、反注册关联服务器 ---------------------------------------
        unregister_dispatcher(mConfig);//反注册到服务监听器
        unregister_monitor(mConfig);//反注册到服务监听器
    }

    //---------------------------------------Global----------------------------------------------------
    public static ArgsConfig libArgsConfig;
    public static Config mConfig;
    public static NioClient [] dispatcher;
    public static byte[] write_buf = new byte[16*1024];
    public static byte[] write_buff_dispatcher = new byte[16*1024];
    public static MessageHandler mHandler = new MessageHandler();
    //---------------------------------------Monitor----------------------------------------------------
    public static void register_monitor(Config mConfig){
        Monitor.register2Monitor(write_buf,libArgsConfig.server_type,libArgsConfig.name, libArgsConfig.id,libArgsConfig.host, libArgsConfig.port);
        int monitorSize = (null != mConfig.monitor_net_udp) ? mConfig.monitor_net_udp.length : 0;
    	if(monitorSize > 0){
    		for(int i=0; i< monitorSize ; i++){
    			NetUtil.send_data_by_udp_nio(mConfig.monitor_net_udp[i].ip, mConfig.monitor_net_udp[i].port,write_buf,0,DataPacket.getLength(write_buf));
    		}
    	}
    }
    
    public static void unregister_monitor(Config mConfig){
    	Monitor.unregister2Monitor(write_buf,libArgsConfig.server_type,libArgsConfig.name, libArgsConfig.id,libArgsConfig.host, libArgsConfig.port);
        int monitorSize = (null != mConfig.monitor_net_udp) ? mConfig.monitor_net_udp.length : 0;
    	if(monitorSize > 0){
    		for(int i=0; i< monitorSize ; i++){
    			NetUtil.send_data_by_udp_nio(mConfig.monitor_net_udp[i].ip, mConfig.monitor_net_udp[i].port,write_buf,0,DataPacket.getLength(write_buf));
    		}
    	}
    }
    
    //---------------------------------------Dispatcher----------------------------------------------------
    public static void register_dispatcher(Config mConfig){
    	int dispatcherSize = (null != mConfig.dispatcher_net_tcp) ? mConfig.dispatcher_net_tcp.length : 0;
    	if(dispatcherSize > 0){
    		dispatcher = new NioClient[dispatcherSize];
    		for(int i=0; i< dispatcherSize ; i++){
    			dispatcher[i] = new NioClient(mDisPatcherMessageProcessor,mDisPatcherConnectResultListener); 
    			dispatcher[i].setConnectAddress(new TcpAddress[]{mConfig.dispatcher_net_tcp[i]});
    			dispatcher[i].connect();
    		}
    	}
    }
    
    public static void unregister_dispatcher(Config mConfig){
    	int dispatcherSize = (null != dispatcher) ? dispatcher.length : 0;
    	if(dispatcherSize > 0){
    		for(int i=0; i< dispatcherSize ; i++){
    			dispatcher[i].disconnect();
    		}
    	}
    }
    
	private static IConnectListener mDisPatcherConnectResultListener = new IConnectListener() {
		@Override
		public void onConnectionSuccess(AbstractClient client) {
			Logger.v("-------dispatcher onConnectionSuccess---------" +Arrays.toString(((NioClient)client).getConnectAddress()));
			//register to dispatchServer
			int length = Dispatcher.register2Dispatcher(write_buf,libArgsConfig.server_type,libArgsConfig.name, libArgsConfig.id,libArgsConfig.host, libArgsConfig.port,mConfig.game_id,-1);
			mDisPatcherMessageProcessor.send(client,write_buf,0,length);
			
			//上报桌子信息
			mHandler.report_roominfo(write_buff_dispatcher, write_buf, 1, mDisPatcherMessageProcessor, mConfig);
		}

		@Override
		public void onConnectionFailed(AbstractClient client) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(NioClient mClient: dispatcher){
				if(mClient == client){
					Logger.v("-------dispatcher onConnectionFailed---------" +Arrays.toString(((NioClient)client).getConnectAddress()));
					mClient.connect();
					break;
				}
			}
		}
	};

    //-------------------------------------------------------------------------------------------
    public static LogListener mLogListener = new LogListener(){

		@Override
		public void onLog(String tag, String msg) {
			Logger.v(msg);
		}
    };
    
    //-------------------------------------------------------------------------------------------
	private static AbstractClientMessageProcessor mDisPatcherMessageProcessor =new AbstractClientMessageProcessor() {

		@Override
		public void onReceiveMessages(AbstractClient mClient, LinkedList<Message> list) {
			for(int i = 0 ;i<list.size();i++){
				Message msg = list.get(i);
	        	try{
	        		
					int cmd = DataPacket.getCmd(msg.data, msg.offset);
					int squenceId = DataPacket.getSequenceId(msg.data,msg.offset);
					
		        	String sCmd = Integer.toHexString(cmd);

		        	System.out.println(String.format("onReceiveMessage mDisPatcherMessageProcessor 0x%s  squenceId %s",sCmd,squenceId));
		        	Logger.v(String.format("onReceiveMessage mDisPatcherMessageProcessor 0x%s  squenceId %s",sCmd,squenceId));
		        	
		        	if(cmd == AllocatorCmd.CMD_GET_ROOMINFO){
		        		mHandler.on_get_roominfo(write_buff_dispatcher,write_buf,1,mDisPatcherMessageProcessor,mConfig,null);
		        	}
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
			}
		}
	};
}
