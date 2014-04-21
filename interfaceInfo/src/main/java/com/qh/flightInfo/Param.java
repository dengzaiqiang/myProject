package com.qh.flightInfo;

import javax.xml.bind.annotation.XmlElement;

/**
 * 航班参数信息
 * @author Administrator
 *
 */
public class Param {

	private String fromCity;//出发城市代码
	private String toCity;//到达城市代码
	private String depDate;//出发日期
	private String carrier;//航空公司代码
	@XmlElement(name="FromCityCode")
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	@XmlElement(name="ToCityCode")
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	@XmlElement(name="DepartureDate")
	public String getDepDate() {
		return depDate;
	}
	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}
	@XmlElement(name="CarrierCode")
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public Param(String fromCity, String toCity, String depDate, String carrier) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.depDate = depDate;
		this.carrier = carrier;
	}
	public Param() {
		super();
	}
	
	
	
}
