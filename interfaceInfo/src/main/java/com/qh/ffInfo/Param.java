package com.qh.ffInfo;

import javax.xml.bind.annotation.XmlElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�Param   
* ��������  ���� 
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��18�� ����4:28:46   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��18�� ����4:28:46   
* �޸ı�ע��   
* @version    
*
 */
public class Param {
	private String flightNo;
	private String depDate;
	@XmlElement(name="FlightNo")
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	@XmlElement(name="DepartureDate")
	public String getDepDate() {
		return depDate;
	}
	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}
	public Param(String flightNo, String depDate) {
		super();
		this.flightNo = flightNo;
		this.depDate = depDate;
	}
	public Param() {
		super();
	}
	
	
}
