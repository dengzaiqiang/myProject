package com.qh.pay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：PayParams   
* 类描述：  支付订单 
* 创建人：dengzaiqiang   
* 创建时间：2014年4月22日 下午1:38:14   
* 修改人：  
* 修改时间：2014年4月22日 下午1:38:14   
* 修改备注：   
* @version    
*
 */
@XmlRootElement(name="ParamsXml")
public class PayParams {
	
	private PayParam param;
	@XmlElement(name="Params")
	public PayParam getParam() {
		return param;
	}

	public void setParam(PayParam param) {
		this.param = param;
	}

	public PayParams(PayParam param) {
		super();
		this.param = param;
	}

	public PayParams() {
		super();
	}
	
}
