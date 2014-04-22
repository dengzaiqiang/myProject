package com.qh.pat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：PatParams   
* 类描述：  匹配参数 
* 创建人：dengzaiqiang   
* 创建时间：2014年4月22日 上午10:09:53   
* 修改人：  
* 修改时间：2014年4月22日 上午10:09:53   
* 修改备注：   
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
