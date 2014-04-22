package com.qh.apply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�ApplyParam   
* ��������   ��ȡ�˸�ǩ�涨
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��22�� ����1:29:52   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��22�� ����1:29:52   
* �޸ı�ע��   
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
