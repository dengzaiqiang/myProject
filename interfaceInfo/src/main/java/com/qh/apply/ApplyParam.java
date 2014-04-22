package com.qh.apply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：ApplyParam   
* 类描述：   获取退改签规定
* 创建人：dengzaiqiang   
* 创建时间：2014年4月22日 下午1:29:52   
* 修改人：  
* 修改时间：2014年4月22日 下午1:29:52   
* 修改备注：   
* @version    
*
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplyParam {
	@XmlElement(name="Carrier")
	private String carrier;//
	@XmlElement(name="PolicyID")
	private String policyId;
	@XmlElement(name="Class")
	private String cabin;
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public ApplyParam(String carrier, String policyId, String cabin) {
		super();
		this.carrier = carrier;
		this.policyId = policyId;
		this.cabin = cabin;
	}
	public ApplyParam() {
		super();
	}
	
}
