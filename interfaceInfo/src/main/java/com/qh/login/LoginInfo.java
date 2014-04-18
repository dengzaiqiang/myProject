package com.qh.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：LoginInfo   
* 类描述：登陆验证信息   
* 创建人：dengzaiqiang   
* 创建时间：2014年4月18日 下午3:57:37   
* 修改人：  
* 修改时间：2014年4月18日 下午3:57:37   
* 修改备注：   
* @version    
*
 */
@XmlRootElement(name="LoginInfoBase")
public class LoginInfo {
	
	private final int ClientID=2305;//客户ID
	private final String UserName="qhwcgs";//用户名
	private final String Password="502397D347DA2FB725538BC754502AB377DC3F14";//密码
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
