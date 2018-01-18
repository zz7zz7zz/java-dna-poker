package com.poker.games;

public class User {
	
	public long uid;//用户唯一Id
	public String nick_name;//用户昵称
	public String head_portrait;//头像
	public long chip;//用户筹码
	public int level;//用户等级
	
	public int seatId = -1;//座位id
	
	public void reset(){
		uid = 0;
		chip = 0;
		level = 0;
		
		seatId = 0;
	}
}
