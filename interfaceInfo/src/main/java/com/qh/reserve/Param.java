package com.qh.reserve;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
/**
 * 预定机票参数
 * @author Administrator
 *
 */
@XmlType(propOrder={"linkMan","linkTel","policyId","reamrk","passengerInfos","flightTrips","passengerCardInfos"})
public class Param {

	private String linkMan;//联系人
	private String linkTel;//联系电话
	private String policyId;//政策ID
	private String reamrk;//备注
	
	private PassengerInfos passengerInfos;//旅客信息
	private FlightTrips flightTrips;//航线信息
	private PassengerCardInfos passengerCardInfos;//常旅客卡信息
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
