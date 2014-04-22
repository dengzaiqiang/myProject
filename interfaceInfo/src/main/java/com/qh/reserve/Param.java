package com.qh.reserve;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
/**
 * Ԥ����Ʊ����
 * @author Administrator
 *
 */
@XmlType(propOrder={"linkMan","linkTel","policyId","reamrk","passengerInfos","flightTrips","passengerCardInfos"})
public class Param {

	private String linkMan;//��ϵ��
	private String linkTel;//��ϵ�绰
	private String policyId;//����ID
	private String reamrk;//��ע
	
	private PassengerInfos passengerInfos;//�ÿ���Ϣ
	private FlightTrips flightTrips;//������Ϣ
	private PassengerCardInfos passengerCardInfos;//���ÿͿ���Ϣ
	@XmlElement(name="LinkMan")
	public String getLinkMan() {
		return linkMan;
	}
	@XmlElement(name="LinkTel")
	public String getLinkTel() {
		return linkTel;
	}
	@XmlElement(name="PolicyID")
	public String getPolicyId() {
		return policyId;
	}
	@XmlElement(name="Remark")
	public String getReamrk() {
		return reamrk;
	}
	@XmlElement(name="PassengerInfos")
	public PassengerInfos getPassengerInfos() {
		return passengerInfos;
	}
	@XmlElement(name="FlightTrips")
	public FlightTrips getFlightTrips() {
		return flightTrips;
	}
	@XmlElement(name="PasserCardInfos")
	public PassengerCardInfos getPassengerCardInfos() {
		return passengerCardInfos;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}
	public void setPassengerInfos(PassengerInfos passengerInfos) {
		this.passengerInfos = passengerInfos;
	}
	public void setFlightTrips(FlightTrips flightTrips) {
		this.flightTrips = flightTrips;
	}
	public void setPassengerCardInfos(PassengerCardInfos passengerCardInfos) {
		this.passengerCardInfos = passengerCardInfos;
	}
	
	
	
}
