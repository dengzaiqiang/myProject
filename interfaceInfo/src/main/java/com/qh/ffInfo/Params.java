package com.qh.ffInfo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�Params   
* �������� ���ྭͣ����  
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��18�� ����4:27:23   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��18�� ����4:27:23   
* �޸ı�ע��   
* @version    
*
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
