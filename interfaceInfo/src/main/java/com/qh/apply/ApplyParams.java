package com.qh.apply;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�ApplyParams   
* ��������  ��ȡ �˸�ǩ�涨   ����
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��22�� ����1:29:08   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��22�� ����1:29:08   
* �޸ı�ע��   
* @version    
*
 */
@XmlRootElement(name="ParamsXml")
public class ApplyParams {

	private ApplyParam param;
	@XmlElement(name="Params")
	public ApplyParam getParam() {
		return param;
	}

	public void setParam(ApplyParam param) {
		this.param = param;
	}

	public ApplyParams(ApplyParam param) {
		super();
		this.param = param;
	}

	public ApplyParams() {
		super();
	}
	
	
}
