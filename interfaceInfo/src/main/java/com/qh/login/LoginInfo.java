package com.qh.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�LoginInfo   
* ����������½��֤��Ϣ   
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��18�� ����3:57:37   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��18�� ����3:57:37   
* �޸ı�ע��   
* @version    
*
 */
@XmlRootElement(name="LoginInfoBase")
public class LoginInfo {
	
	private final int ClientID=2305;//�ͻ�ID
	private final String UserName="qhwcgs";//�û���
	private final String Password="502397D347DA2FB725538BC754502AB377DC3F14";//����
	@XmlElement(name="ClientID")
	public int getClientID() {
		return ClientID;
	}
	@XmlElement(name="UserName")
	public String getUserName() {
		return UserName;
	}
	@XmlElement(name="Password")
	public String getPassword() {
		return Password;
	}
	
	
}
