package com.qh.ffInfo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：Params   
* 类描述： 航班经停参数  
* 创建人：dengzaiqiang   
* 创建时间：2014年4月18日 下午4:27:23   
* 修改人：  
* 修改时间：2014年4月18日 下午4:27:23   
* 修改备注：   
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
