package com.qh.ffInfo;
/**
 * 经停机场信息
 * @author Administrator
 *
 */
public class FFInfo {
	
	private String airPort;//机场三字码
	private String arrTime;//到达时间
	private String depTime;//出发时间
	private String airCraft;//机型
	public String getAirPort() {
		return airPort;
	}
	public void setAirPort(String airPort) {
		this.airPort = airPort;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getAirCraft() {
		return airCraft;
	}
	public void setAirCraft(String airCraft) {
		this.airCraft = airCraft;
	}
	
}
