package com.qh.pay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�PayParams   
* ��������  ֧������ 
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��22�� ����1:38:14   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��22�� ����1:38:14   
* �޸ı�ע��   
* @version    
*
 */
@XmlRootElement(name="ParamsXml")
public class PayParams {
	
	private PayParam param;
	@XmlElement(name="Params")
	public PayParam getParam() {
		return param;
	}

	public void setParam(PayParam param) {
		this.param = param;
	}

	public PayParams(PayParam param) {
		super();
		this.param = param;
	}

	public PayParams() {
		super();
	}
	
}
