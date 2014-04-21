package com.qh.reserve;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * ÂÃ¿ÍÐÅÏ¢
 * @author Administrator
 *
 */
public class PassengerInfos {

	private List<CPassengerInfo> cPassengerInfo;//
	@XmlElement(name="CPassengerInfo")
	public List<CPassengerInfo> getcPassengerInfo() {
		return cPassengerInfo;
	}

	public void setcPassengerInfo(List<CPassengerInfo> cPassengerInfo) {
		this.cPassengerInfo = cPassengerInfo;
	}

	public PassengerInfos(List<CPassengerInfo> cPassengerInfo) {
		super();
		this.cPassengerInfo = cPassengerInfo;
	}

	public PassengerInfos() {
		super();
	}
	
	
}
