package com.qh.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：SearchParams   
* 类描述：  查询订单参数 
* 创建人：dengzaiqiang   
* 创建时间：2014年4月22日 上午10:33:41   
* 修改人：  
* 修改时间：2014年4月22日 上午10:33:41   
* 修改备注：   
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
