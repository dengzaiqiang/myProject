package com.qh.reserve;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * ÂÃ¿Í³£ÓÃ¿¨
 * @author Administrator
 *
 */
public class PassengerCardInfos {

	private List<CPassengerCardInfo> cPassengerCardInfo;//
	@XmlElement(name="CPasserCardInfo")
	public List<CPassengerCardInfo> getcPassengerCardInfo() {
		return cPassengerCardInfo;
	}

	public void setcPassengerCardInfo(List<CPassengerCardInfo> cPassengerCardInfo) {
		this.cPassengerCardInfo = cPassengerCardInfo;
	}

	public PassengerCardInfos(List<CPassengerCardInfo> cPassengerCardInfo) {
		super();
		this.cPassengerCardInfo = cPassengerCardInfo;
	}

	public PassengerCardInfos() {
		super();
	}
	
	
}
