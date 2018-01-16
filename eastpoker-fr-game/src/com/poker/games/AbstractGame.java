package com.poker.games;

public abstract class AbstractGame {
	
	public void onUserEnter(User mUser){
		
	};
	
	public void onUserExit(User mUser){
		
	};
	
	public void onUserReady(User mUser){
		
	};
	
	public void onUserOffline(User mUser){
		
	};
	
	public void onKickUser(User mUser , User kickedUser){
		
	};
	
	public void onSendCmd(int cmd, byte[] data, int offset, int length){
		
	};
	
	//------------------------------------子游戏必需实现的业务逻辑------------------------------------
	protected abstract void onReceiveCmd(User mUser, int cmd, byte[] data, int offset, int length);

}
