package com.qh.ffInfo;

import javax.xml.bind.annotation.XmlElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：Param   
* 类描述：  参数 
* 创建人：dengzaiqiang   
* 创建时间：2014年4月18日 下午4:28:46   
* 修改人：  
* 修改时间：2014年4月18日 下午4:28:46   
* 修改备注：   
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
