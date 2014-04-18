package com.qh.util;

import java.io.StringWriter;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.w3c.dom.NodeList;


/**
*    
* 项目名称：interfaceInfo   
* 类名称：WebServiceUtils   
* 类描述：  webservice请求工具类
* 创建人：dengzaiqiang   
* 创建时间：2014年4月18日 下午1:29:01   
* 修改人：  
* 修改时间：2014年4月18日 下午1:29:01   
* 修改备注：   
* @version    
*
 */
public class WebServiceUtils {

	private final static String ENDPOINT="http://btobapi.service.test.itour.com.cn:8003/ItourCrsService.asmx";
	private final static String QNAME="http://tempuri.org/";
	/**
	 * 
	* @Title: invokeMethod
	* @Description: 接口方法调用
	* @param methodName 方法名
	* @param linkedMap  -->key参数名，value 值 
	* @return String    
	* @throws
	 */
	public static String invokeMethod(String methodName,Map<String,Object> linkedMap){
		String res = "";
		try {
			Service service = new Service();
			Call call = null;
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(ENDPOINT));
			call.setOperationName(new QName(QNAME,methodName));
			call.setUseSOAPAction(true);
			call.setSOAPActionURI(QNAME+methodName);
			call.setReturnClass(java.lang.String.class);
			if(null!=linkedMap&&linkedMap.size()>0){
				for(String param:linkedMap.keySet()){
					call.addParameter(new javax.xml.namespace.QName(QNAME,param),XMLType.XSD_STRING,ParameterMode.IN);
				}
				res = ((String)call.invoke(linkedMap.values().toArray()));
			}
			/*
			call.addParameter(new javax.xml.namespace.QName(QNAME,"productNo"),XMLType.XSD_STRING,ParameterMode.IN);
			call.addParameter(new javax.xml.namespace.QName(QNAME,"type"),XMLType.XSD_STRING,ParameterMode.IN);
			call.addParameter(new javax.xml.namespace.QName(QNAME,"name"),XMLType.XSD_STRING,ParameterMode.IN);*/
			else{
				res =(String)call.invoke(methodName,null);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	* @Title: parseResultXml
	* @Description: 解析调用接口方法后返回的XML字串   
	* @return Map<String,Object> 解析的XML字串内容
	* @throws
	 */
	public static Map<String,Object> parseResultXml(String resultXml){
		Map<String,Object> map = null;
		try {
			Document doc = DocumentHelper.parseText(resultXml);
			map = new HashMap<String,Object>();
			Element root = doc.getRootElement();
			List<Node> list = root.selectNodes("AirPortInfo/CNHotCity");
			for(Node node:list){
				System.out.println("nodeName:"+node.getStringValue());
			}
			//System.out.println(hotCity.getTextTrim());
			List<Element> eleLists = root.elements();
			for(Element ele:eleLists){
				//System.out.println("name="+ele.getName()+":"+ele.getStringValue());
				map.put(ele.getName(), ele.getStringValue());
			}
		} catch (DocumentException e) {
			System.out.println("解析resultXml出错");
			e.printStackTrace();
		}
		return map;
	}
	/**
	* @Title: getContentForXPath
	* @Description: 根据xpath查找指定的节点的内容（只有第一个节点的内容会返回）
	* @param  
	* @return String
	 */
	public static String getContentForXPath(String resultXml,String xpath){
		String content= "";
		try {
			Document doc = DocumentHelper.parseText(resultXml);
			Element root = doc.getRootElement();
			List<Node> list = root.selectNodes(xpath);
			for(Node node:list){
				//System.out.println(node.getName()+":"+node.getStringValue());
			}
			content = list.get(0).getStringValue();
		} catch (DocumentException e) {
			System.out.println("解析resultXml出错");
			e.printStackTrace();
		}
		return content;
	}
	/**
	* @Title: beanToXml
	* @Description: 将实体类转换成XML格式
	* @param  
	* @return String
	 */
	public static String beanToXml(Object obj,Class clazz){
		try {
			StringWriter sw = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.marshal(obj, sw);
			return sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
