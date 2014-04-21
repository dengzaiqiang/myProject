package com.qh.reserve;

import javax.xml.bind.annotation.XmlElement;

/**
 * 旅客常 用卡信息
 * @author Administrator
 *
 */
public class CPassengerCardInfo {
	
	private String pid;//uuid唯一标识
	private String cardNo;//卡号
	private String carrier;//航空公司二字码
	@XmlElement(name="Pid")
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@XmlElement(name="CardNo")
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@XmlElement(name="Carrier")
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public CPassengerCardInfo(String pid, String cardNo, String carrier) {
		super();
		this.pid = pid;
		this.cardNo = cardNo;
		this.carrier = carrier;
	}
	public CPassengerCardInfo() {
		super();
	}
	
	

}
