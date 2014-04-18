package interfaceInfo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
	* @param  methodName��������likedMap ����map���ϣ�ʹ��linkedMap�࣬ resultNameΪ��ȡ�Ľ���ı�ǩ��
	* @return Map<String,Object>
	 */
	private String getReturnString(String methodName,Map<String,Object> likedMap,String resultName){
		String resultXml = WebServiceUtils.
				invokeMethod(methodName, likedMap);
		//System.out.println(resultXml);
		Map<String,Object> resultMap = WebServiceUtils.parseResultXml(resultXml);
		for(String str :resultMap.keySet()){
			//System.out.println(str+":"+resultMap.get(str));
		}
		String resultContent = (String)resultMap.get(resultName);
		return resultContent;
	}
	
	@Test
	public void getFFInfo(){
		HashMap<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml ", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		
		Param param = new Param("CZ3101","2014-05-16");
		linkedMap.put("paramsXml ", WebServiceUtils.beanToXml(new Params(param), Params.class));
		
		String resultXml = getReturnString("GetFFInfo",linkedMap,RESULT);
		System.out.println(resultXml);
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
