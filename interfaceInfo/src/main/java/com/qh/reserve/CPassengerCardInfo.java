package com.qh.reserve;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * �ÿͳ� �ÿ���Ϣ
 * @author Administrator
 *
 */
@XmlType(propOrder={"pid","cardNo","carrier"})
public class CPassengerCardInfo {
	
	private String pid;//uuidΨһ��ʶ
	private String cardNo;//����
	private String carrier;//���չ�˾������
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
