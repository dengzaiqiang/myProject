package com.qh.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：PayParam   
* 类描述： 支付订单  
* 创建人：dengzaiqiang   
* 创建时间：2014年4月22日 下午1:38:45   
* 修改人：  
* 修改时间：2014年4月22日 下午1:38:45   
* 修改备注：   
* @version    
*
 */
@XmlAccessorType(XmlAccessType.FIELD)//使用字段映射
public class PayParam {
	@XmlElement(name="OrderID")
	private String orderId;
	@XmlElement(name="PNR")
	private String pnr;
	@XmlElement(name="PayGathering")
	private String payGathering;//支付金额
	public PayParam(String orderId, String pnr, String payGathering) {
		super();
		this.orderId = orderId;
		this.pnr = pnr;
		this.payGathering = payGathering;
	}
	public PayParam() {
		super();
	}
	
}
