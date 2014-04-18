package com.qh.airCraft;
/**
*    
* 项目名称：interfaceInfo   
* 类名称：AirCraft   
* 类描述：  机型 
* 创建人：dengzaiqiang   
* 创建时间：2014年4月18日 下午3:15:08   
* 修改人：  
* 修改时间：2014年4月18日 下午3:15:08   
* 修改备注：   
* @version    
*
 */
public class AirCraft {
	
	private String airCraftName;//机型名称
	private String airCraftType;//机型类型
	private String makeCompany;//制造公司
	private String serie;//系列
	private String seatNum;//座位数
	public String getAirCraftName() {
		return airCraftName;
	}
	public void setAirCraftName(String airCraftName) {
		this.airCraftName = airCraftName;
	}
	public String getAirCraftType() {
		return airCraftType;
	}
	public void setAirCraftType(String airCraftType) {
		this.airCraftType = airCraftType;
	}
	public String getMakeCompany() {
		return makeCompany;
	}
	public void setMakeCompany(String makeCompany) {
		this.makeCompany = makeCompany;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	
}
