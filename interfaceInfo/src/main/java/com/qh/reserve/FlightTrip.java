package com.qh.reserve;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ������Ϣ
 * @author Administrator
 *
 */
@XmlType(propOrder={"fromCity","toCity","flightDate","flightNo","cabin"})
public class FlightTrip {

	private String fromCity;//��������
	private String toCity;//�������\
	private String flightDate;//���ʱ��
	private String flightNo;//�����
	private String cabin;//��λ
	@XmlElement(name="FromCity")
	public String getFromCity() {
		return fromCity;
	}
	@XmlElement(name="ToCity")
	public String getToCity() {
		return toCity;
	}
	@XmlElement(name="FlightDate")
	public String getFlightDate() {
		return flightDate;
	}
	@XmlElement(name="FlightNo")
	public String getFlightNo() {
		return flightNo;
	}
	@XmlElement(name="Class")
	public String getCabin() {
		return cabin;
	}
	public FlightTrip(String fromCity, String toCity, String flightDate,
			String flightNo, String cabin) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.flightDate = flightDate;
		this.flightNo = flightNo;
		this.cabin = cabin;
	}
	public FlightTrip() {
		super();
	}
	
	
}
