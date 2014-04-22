package com.qh.pat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�PatParam   
* ��������  ƥ����� 
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��22�� ����10:11:10   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��22�� ����10:11:10   
* �޸ı�ע��   
* @version    
*
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PatParam {
	@XmlElement(name="PNR")
	private String pnr;
	@XmlElement(name="BigClientID")
	private String bigClient;//��ͻ��ţ���Ϊ��
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getBigClient() {
		return bigClient;
	}
	public void setBigClient(String bigClient) {
		this.bigClient = bigClient;
	}
	public PatParam(String pnr, String bigClient) {
		super();
		this.pnr = pnr;
		this.bigClient = bigClient;
	}
	public PatParam() {
		super();
	}
	
	

}
