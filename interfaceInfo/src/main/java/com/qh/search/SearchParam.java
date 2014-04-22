package com.qh.search;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
*    
* 项目名称：interfaceInfo   
* 类名称：SearchParam   
* 类描述：  订单查询参数 
* 创建人：dengzaiqiang   
* 创建时间：2014年4月22日 上午10:35:03   
* 修改人：  
* 修改时间：2014年4月22日 上午10:35:03   
* 修改备注：   
* @version    
*
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchParam {
	@XmlElement(name="PNR")
	private String pnr;
	@XmlElement(name="TicketNum")
	private String tiketNum;//票号
	@XmlElement(name="OrderNo")
	private String orderNo;//订单号
	@XmlElement(name="PassengerName")
	private String passengerName;//旅客姓名
	@XmlElement(name="CreateStartDate")
	private String createStartDate;//订单生成 起始日期
	@XmlElement(name="CreateEndDate")
	private String createEndDate;//
	@XmlElement(name="PageIndex")
	private String pageIndex;//页数
	@XmlElement(name="PageSize")
	private String pageSize;//每页大小
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getTiketNum() {
		return tiketNum;
	}
	public void setTiketNum(String tiketNum) {
		this.tiketNum = tiketNum;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getCreateStartDate() {
		return createStartDate;
	}
	public void setCreateStartDate(String createStartDate) {
		this.createStartDate = createStartDate;
	}
	public String getCreateEndDate() {
		return createEndDate;
	}
	public void setCreateEndDate(String createEndDate) {
		this.createEndDate = createEndDate;
	}
	public String getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public SearchParam(String pnr, String tiketNum, String orderNo,
			String passengerName, String createStartDate, String createEndDate,
			String pageIndex, String pageSize) {
		super();
		this.pnr = pnr;
		this.tiketNum = tiketNum;
		this.orderNo = orderNo;
		this.passengerName = passengerName;
		this.createStartDate = createStartDate;
		this.createEndDate = createEndDate;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public SearchParam() {
		super();
	}
	
	

}
