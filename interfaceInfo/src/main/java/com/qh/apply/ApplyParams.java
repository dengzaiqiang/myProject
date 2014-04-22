package com.qh.apply;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：ApplyParams   
* 类描述：  获取 退改签规定   参数
* 创建人：dengzaiqiang   
* 创建时间：2014年4月22日 下午1:29:08   
* 修改人：  
* 修改时间：2014年4月22日 下午1:29:08   
* 修改备注：   
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
