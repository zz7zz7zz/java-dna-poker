package com.poker.dispatcher;

import java.io.IOException;
import java.nio.ByteBuffer;

import com.open.net.server.GServer;
import com.open.net.server.impl.tcp.nio.NioClient;
import com.open.net.server.impl.tcp.nio.NioServer;
import com.open.net.server.structures.AbstractClient;
import com.open.net.server.structures.AbstractMessageProcessor;
import com.open.net.server.structures.ServerConfig;
import com.open.net.server.structures.ServerLog;
import com.open.net.server.structures.ServerLog.LogListener;
import com.open.net.server.structures.message.Message;
import com.open.net.server.utils.NetUtil;
import com.open.util.log.Logger;
import com.poker.common.config.Config;

/**
 * author       :   long
 * created on   :   2017/11/30
 * description  :  服务器入口
 */

public class Main {

    public static void main(String [] args){
    	
    	//1.1 配置初始化
        ServerConfig mServerInfo = new ServerConfig();
        mServerInfo.initArgsConfig(args);
        mServerInfo.initFileConfig("./conf/lib.server.config");
        
        //1.2 数据初始化
        GServer.init(mServerInfo, NioClient.class);
        
        //1.3 日志初始化
        Logger.init("./conf/lib.log.config",mServerInfo.id);
        Logger.addFilterTraceElement(ServerLog.class.getName());
        Logger.addFilterTraceElement(mLogListener.getClass().getName());
        Logger.v("-------Server------"+ mServerInfo.toString());
        
        //1.4 业务配置初始化
        Config mConfig = new Config();
        mConfig.initFileConfig("./conf/server.config");
        
        Logger.v("-------Server------start---------");
        
        //2.1 发送给服务监听器
    	NetUtil.send_data_by_udp_nio("", 9995, String.format("%s %d Enter", mServerInfo.name,mServerInfo.id).getBytes());
    	
        try {
            NioServer mNioServer = new NioServer(mServerInfo,mMessageProcessor,mLogListener);
            mNioServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    	NetUtil.send_data_by_udp_nio("", 9995, String.format("%s %d Exit", mServerInfo.name,mServerInfo.id).getBytes());
        Logger.v("-------Server------end---------");
    }

    //-------------------------------------------------------------------------------------------
    public static AbstractMessageProcessor mMessageProcessor = new AbstractMessageProcessor() {

        private ByteBuffer mWriteBuffer  = ByteBuffer.allocate(128*1024);
        private long oldTime = System.currentTimeMillis();
        private long nowTime  = oldTime;
        
        protected void onReceiveMessage(AbstractClient client, Message msg){

            Logger.v("--onReceiveMessage()- rece  "+new String(msg.data,msg.offset,msg.length));
            String data ="MainNioServer--onReceiveMessage()--src_reuse_type "+msg.src_reuse_type
                    + " dst_reuse_type " + msg.dst_reuse_type
                    + " block_index " +msg.block_index
                    + " offset " +msg.offset;
            Logger.v("--onReceiveMessage()--reply "+data);
            
            byte[] response = data.getBytes();

            mWriteBuffer.clear();
            mWriteBuffer.put(response,0,response.length);
            mWriteBuffer.flip();
//        unicast(client,mWriteBuffer.array(),0,response.length);
            broadcast(mWriteBuffer.array(),0,response.length);
            mWriteBuffer.clear();
        }
        
		@Override
		public void onTimeTick() {
			nowTime = System.currentTimeMillis();
			if(nowTime - oldTime > 1000){
				oldTime = nowTime;
				
			}
		}

		@Override
		public void onClientEnter(AbstractClient client) {
			System.out.println("onClientEnter " + client.mClientId);
		}

		@Override
		public void onClientExit(AbstractClient client) {
			System.out.println("onClientExit " + client.mClientId);
		}
    };
    
    public static LogListener mLogListener = new LogListener(){

		@Override
		public void onLog(String tag, String msg) {
			Logger.v(msg);
		}
    };
}