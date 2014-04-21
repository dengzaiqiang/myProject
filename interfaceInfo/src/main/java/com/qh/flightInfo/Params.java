package com.qh.flightInfo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 航班参数信息
 */
@XmlRootElement(name="ParamsXml")
public class Params {

	private Param param;
	@XmlElement(name="Params")
	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public Params(Param param) {
		super();
		this.param = param;
	}

	public Params() {
		super();
	}
	
}
