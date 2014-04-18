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
* 项目名称：interfaceInfo   
* 类名称：WebServiceTest   
* 类描述：  测试webService 
* 创建人：dengzaiqiang   
* 创建时间：2014年4月18日 下午1:36:13   
* 修改人：  
* 修改时间：2014年4月18日 下午1:36:13   
* 修改备注：   
* @version    
*
 */
public class WebServiceTest {
	private final static String RESULT = "Result"; 
	/**
	* @Title: getReturnMap
	* @Description: 通用调用(接口返回内容)
	* @param  methodName方法名，likedMap 参数map集合，使用linkedMap类， resultName为想取的结果的标签名
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
	* @Description: 获取机型信息
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
	* @Description: 获取热门城市 ，所有城市 和所有城市 的对应机场
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
	* @Description:获取所有航空公司 
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
