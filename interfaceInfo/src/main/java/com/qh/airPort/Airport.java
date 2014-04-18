package com.qh.airPort;
/**
*    
* 项目名称：interfaceInfo   
* 类名称：Airport   
* 类描述：   机场类
* 创建人：dengzaiqiang   
* 创建时间：2014年4月18日 下午3:13:19   
* 修改人：  
* 修改时间：2014年4月18日 下午3:13:19   
* 修改备注：   
* @version    
*
 */
public class Airport {
	
	private String ename;//英文名称
	private String cname;//中文名称
	private String jcSan;//机场三字码
	private String csSan;//城市三字码
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getJcSan() {
		return jcSan;
	}
	public void setJcSan(String jcSan) {
		this.jcSan = jcSan;
	}
	public String getCsSan() {
		return csSan;
	}
	public void setCsSan(String csSan) {
		this.csSan = csSan;
	}
	
}
