package com.qh.policy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * �������߲�ѯ����
 * @author Administrator
 *
 */
@XmlRootElement(name="ParamsXml")
public class PolicyParams {

	private PolicyParam param;
	@XmlElement(name="Params")
	public PolicyParam getParam() {
		return param;
	}

	public void setParam(PolicyParam param) {
		this.param = param;
	}

	public PolicyParams(PolicyParam param) {
		super();
		this.param = param;
	}

	public PolicyParams() {
		super();
	}
	
	
}
