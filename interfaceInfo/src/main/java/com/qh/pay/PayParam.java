package com.qh.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�PayParam   
* �������� ֧������  
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��22�� ����1:38:45   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��22�� ����1:38:45   
* �޸ı�ע��   
* @version    
*
 */
@XmlAccessorType(XmlAccessType.FIELD)//ʹ���ֶ�ӳ��
public class PayParam {
	@XmlElement(name="OrderID")
	private String orderId;
	@XmlElement(name="PNR")
	private String pnr;
	@XmlElement(name="PayGathering")
	private String payGathering;//֧�����
	public PayParam(String orderId, String pnr, String payGathering) {
		super();
		this.orderId = orderId;
		this.pnr = pnr;
		this.payGathering = payGathering;
	}
	public PayParam() {
		super();
	}
	
}
