package com.qh.reserve;

import javax.xml.bind.annotation.XmlElement;

/**
 * �ÿ���Ϣ
 * @author Administrator
 *
 */
public class CPassengerInfo {
	
	private String pid;//uuid����Ψһ��ʶ
	private String passengerName;//����
	private String passengerType;//�ÿ�����
	private String birthDate;//����
	private String certifyType;//֤������
	private String certifCode;//֤������
	@XmlElement(name="Pid")
	public String getPid() {
		return pid;
	}
	@XmlElement(name="PassengerName")
	public String getPassengerName() {
		return passengerName;
	}
	@XmlElement(name="PassergerType")
	public String getPassengerType() {
		return passengerType;
	}
	@XmlElement(name="BirthDate")
	public String getBirthDate() {
		return birthDate;
	}
	@XmlElement(name="CertifyType")
	public String getCertifyType() {
		return certifyType;
	}
	@XmlElement(name="CertifyCode")
	public String getCertifCode() {
		return certifCode;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public void setCertifyType(String certifyType) {
		this.certifyType = certifyType;
	}
	public void setCertifCode(String certifCode) {
		this.certifCode = certifCode;
	}
	
}
