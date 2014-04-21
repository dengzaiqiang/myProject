package com.qh.policy;

import javax.xml.bind.annotation.XmlElement;

/**
 * �������߲�ѯ����
 * @author Administrator
 *
 */
public class PolicyParam {

	private String depDate;//��������
	private String 	airline;//����
	private String  carrierCode;//���չ�˾����
	private String carbin;//��λ
	private String flightNo;//�����
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
