package com.qh.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�SearchParams   
* ��������  ��ѯ�������� 
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��22�� ����10:33:41   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��22�� ����10:33:41   
* �޸ı�ע��   
* @version    
*
 */
@XmlRootElement(name="ParamsXml")
public class SearchParams {
	
	private SearchParam param;
	@XmlElement(name="Params")
	public SearchParam getParam() {
		return param;
	}

	public void setParam(SearchParam param) {
		this.param = param;
	}

	public SearchParams(SearchParam param) {
		super();
		this.param = param;
	}

	public SearchParams() {
		super();
	}
	
	

}
