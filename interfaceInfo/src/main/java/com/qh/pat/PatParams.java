package com.qh.pat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�PatParams   
* ��������  ƥ����� 
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��22�� ����10:09:53   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��22�� ����10:09:53   
* �޸ı�ע��   
* @version    
*
 */
@XmlRootElement(name="ParamsXml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatParams {
	@XmlElement(name="Params")
	private PatParam param;

	public PatParam getParam() {
		return param;
	}

	public void setParam(PatParam param) {
		this.param = param;
	}

	public PatParams(PatParam param) {
		super();
		this.param = param;
	}

	public PatParams() {
		super();
	}
	
	
	
	

}
