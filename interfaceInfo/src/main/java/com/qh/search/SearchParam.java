package com.qh.search;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�SearchParam   
* ��������  ������ѯ���� 
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��22�� ����10:35:03   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��22�� ����10:35:03   
* �޸ı�ע��   
* @version    
*
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchParam {
	@XmlElement(name="PNR")
	private String pnr;
	@XmlElement(name="TicketNum")
	private String tiketNum;//Ʊ��
	@XmlElement(name="OrderNo")
	private String orderNo;//������
	@XmlElement(name="PassengerName")
	private String passengerName;//�ÿ�����
	@XmlElement(name="CreateStartDate")
	private String createStartDate;//�������� ��ʼ����
	@XmlElement(name="CreateEndDate")
	private String createEndDate;//
	@XmlElement(name="PageIndex")
	private String pageIndex;//ҳ��
	@XmlElement(name="PageSize")
	private String pageSize;//ÿҳ��С
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
