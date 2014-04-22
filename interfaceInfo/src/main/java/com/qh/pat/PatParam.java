package com.qh.pat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：PatParam   
* 类描述：  匹配参数 
* 创建人：dengzaiqiang   
* 创建时间：2014年4月22日 上午10:11:10   
* 修改人：  
* 修改时间：2014年4月22日 上午10:11:10   
* 修改备注：   
* @version    
*
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PatParam {
	@XmlElement(name="PNR")
	private String pnr;
	@XmlElement(name="BigClientID")
	private String bigClient;//大客户号，可为空
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
