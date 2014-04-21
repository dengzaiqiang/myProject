package com.qh.policy;

import javax.xml.bind.annotation.XmlElement;

/**
 * 单程政策查询参数
 * @author Administrator
 *
 */
public class PolicyParam {

	private String depDate;//出发日期
	private String 	airline;//航线
	private String  carrierCode;//航空公司代码
	private String carbin;//舱位
	private String flightNo;//航班号
	@XmlElement(name="DepartureDate")
	public String getDepDate() {
		return depDate;
	}
	@XmlElement(name="Airline")
	public String getAirline() {
		return airline;
	}
	@XmlElement(name="CarrierCode")
	public String getCarrierCode() {
		return carrierCode;
	}
	@XmlElement(name="Class")
	public String getCarbin() {
		return carbin;
	}
	@XmlElement(name="FlightNo")
	public String getFlightNo() {
		return flightNo;
	}
	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public void setCarbin(String carbin) {
		this.carbin = carbin;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public PolicyParam(String depDate, String airline, String carrierCode,
			String carbin, String flightNo) {
		super();
		this.depDate = depDate;
		this.airline = airline;
		this.carrierCode = carrierCode;
		this.carbin = carbin;
		this.flightNo = flightNo;
	}
	public PolicyParam() {
		super();
	}
	
}
