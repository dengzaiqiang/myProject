package interfaceInfo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import com.qh.ffInfo.Param;
import com.qh.ffInfo.Params;
import com.qh.login.LoginInfo;
import com.qh.util.WebServiceUtils;

/**
*    
* ��Ŀ���ƣ�interfaceInfo   
* �����ƣ�WebServiceTest   
* ��������  ����webService 
* �����ˣ�dengzaiqiang   
* ����ʱ�䣺2014��4��18�� ����1:36:13   
* �޸��ˣ�  
* �޸�ʱ�䣺2014��4��18�� ����1:36:13   
* �޸ı�ע��   
* @version    
*
 */
public class WebServiceTest {
	private final static String RESULT = "Result"; 
	/**
	* @Title: getReturnMap
	* @Description: ͨ�õ���(�ӿڷ�������)
	* @param  methodName��������linkedMap ����map���ϣ�ʹ��linkedMap�࣬ resultNameΪ��ȡ�Ľ���ı�ǩ��
	* @return Map<String,Object>
	 */
	private String getReturnString(String methodName,Map<String,Object> linkedMap,String resultName){
		String resultXml = WebServiceUtils.
				invokeMethod(methodName, linkedMap);
		//System.out.println(resultXml);
		if(null==resultName||"".equals(resultName)){
			return resultXml;
		}
		Map<String,Object> resultMap = WebServiceUtils.parseResultXml(resultXml);
		for(String str :resultMap.keySet()){
			//System.out.println(str+":"+resultMap.get(str));
		}
		String resultContent = (String)resultMap.get(resultName);
		return resultContent;
	}
	
	/*@Test
	public void */
	
	
	
	/**
	 * ��ѯֱ�ﺽ��V2������ʱ��
	 */
	@Test
	public void getFlightInfoNonPolicyV2(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		com.qh.flightInfo.Param param = 
				new com.qh.flightInfo.Param("CAN", "LJG", "2014-05-16", "CZ");
		com.qh.flightInfo.Params params = new com.qh.flightInfo.Params(param);
		linkedMap.put("paramsXml", WebServiceUtils.beanToXml(params, com.qh.flightInfo.Params.class));
		
		String resultContent = getReturnString("GetFlightInfoNonPolicyV2", linkedMap, RESULT);
		System.out.println( resultContent);
	}
	
	/**
	 * ��ѯֱ�ﺽ�ࣨƥ���˵������ߣ�
	 */
	@Test
	public void getFlightInfo(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		com.qh.flightInfo.Param param = 
				new com.qh.flightInfo.Param("CAN", "LJG", "2014-05-16", "CZ");
		com.qh.flightInfo.Params params = new com.qh.flightInfo.Params(param);
		linkedMap.put("paramsXml", WebServiceUtils.beanToXml(params, com.qh.flightInfo.Params.class));
		
		String resultContent = getReturnString("GetFlightInfo", linkedMap, RESULT);
		System.out.println( resultContent);
	}
	
	/**
	 * ��ѯֱ�ﺽ��
	 */
	@Test
	public void getFlightInfoNonPolicy(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		com.qh.flightInfo.Param param = 
				new com.qh.flightInfo.Param("CAN", "PEK", "2014-05-16", "CZ");
		com.qh.flightInfo.Params params = new com.qh.flightInfo.Params(param);
		linkedMap.put("paramsXml", WebServiceUtils.beanToXml(params, com.qh.flightInfo.Params.class));
		
		String resultContent = getReturnString("GetFlightInfoNonPolicy", linkedMap, RESULT);
		System.out.println( resultContent);
		
	}
	
	
	
	
	/**
	 * ���� ����� �ͳ��� ���� ��ѯ ����� ��ͣ��Ϣ
	 */
	@Test
	public void getFFInfo(){
		HashMap<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml ", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		
		//Param param = new Param("CZ3101","2014-05-16");
		Param param = new Param("CZ3487","2014-05-16");
		linkedMap.put("paramsXml ", WebServiceUtils.beanToXml(new Params(param), Params.class));
		
		String resultXml = getReturnString("GetFFInfo",linkedMap,RESULT);
		//System.out.println(resultXml);
		//��ɻ�����Ϣ
		String boardPoint = WebServiceUtils.getContentForXPath(resultXml, "BoardPoint");
		//�Ƿ��о�ͣ
		String success = WebServiceUtils.getContentForXPath(resultXml, "Success");
		//System.out.println(success);
		//���������Ϣ
		String endPoint = WebServiceUtils.getContentForXPath(resultXml, "EndPoint");
		
		if("0".equals(success)){
			System.out.println("û�о�ͣ��Ϣ");
		}else if("1".equals(success)){
			List<Element> nodeList = WebServiceUtils.getNodesForXPath(resultXml, "Items/Item");
			for(Element ele:nodeList){
				List<Attribute> attrs = ele.attributes();
				for(Attribute attr:attrs){
					System.out.println(attr.getName()+":"+attr.getValue());
				}
			}
		}
	}
	
	
	
	
	/**
	* @Title: getAirCraft
	* @Description: ��ȡ������Ϣ
	* @param  
	* @return void
	 */
	@Test
	public void getAirCraft(){
		String resultXml = getReturnString("GetAllAirCraft", null, RESULT);
		System.out.println(resultXml);
		String content = WebServiceUtils.getContentForXPath(resultXml, "AirCraftInfo");
		String[] airCrafts = content.split(",");
		for(String str:airCrafts){
			System.out.println(str);
		}
	}
	
	
	
	/**
	* @Title: getAirPort
	* @Description: ��ȡ���ų��� �����г��� �����г��� �Ķ�Ӧ����
	* @param  
	* @return void
	 */
	@Test
	public void getAirPort(){
		String resultXml = getReturnString("GetAirPort",null,RESULT);
		String hotCitys = WebServiceUtils.getContentForXPath(resultXml, "AirPortInfo/CNHotCity");
		String allCitys = WebServiceUtils.getContentForXPath(resultXml, "AirPortInfo/CNAllCity");
		String allAirPorts = WebServiceUtils.getContentForXPath(resultXml, "AirPortInfo/CNAllAirPort");
		
		System.out.println("hotCity:========================================");
		String[] hotCity = hotCitys.split(",");
		for(String str :hotCity){
			//System.out.println(str);
		}
		System.out.println("allCity=============================================");
		String[] allCity = allCitys.split(",");
		for(String str :allCity){
			//System.out.println(str);
		}
		System.out.println("allAirPort=============================================");
		String[] allAirPort = allAirPorts.split(",");
		for(String str :allAirPort){
			//System.out.println(str);
		}
	}
	
	
	
	
	
	
	/**
	* @Title: getAirWays
	* @Description:��ȡ���к��չ�˾ 
	* @param  
	* @return void
	 */
	@Test
	public void getAirWays(){
		
		String resultXml = getReturnString("GetAirWays",null,RESULT);
		Map<String,Object> contentMap = WebServiceUtils.parseResultXml(resultXml);
		for(String str: contentMap.keySet()){
			System.out.println(str+":"+contentMap.get(str));
		}
		String airWays = (String)contentMap.get("AirWayInfo");
		String airway[] = airWays.split(",");
		System.out.println("airway length:"+airway.length);
		for(int i =0;i <airway.length;i++){
			System.out.println(airway[i]);
			/*String airs = airway[i];
			String air[] = airs.split("|");
			*/
		}
	}
	
}
