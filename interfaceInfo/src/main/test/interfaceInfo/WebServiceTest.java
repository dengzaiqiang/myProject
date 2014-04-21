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
	* @param  methodName方法名，linkedMap 参数map集合，使用linkedMap类， resultName为想取的结果的标签名
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
	 * 查询直达航班V2（请求超时）
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
	 * 查询直达航班（匹配了单程政策）
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
	 * 查询直达航班
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
	 * 根据 航班号 和出发 日期 查询 航班的 经停信息
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
		//起飞机场信息
		String boardPoint = WebServiceUtils.getContentForXPath(resultXml, "BoardPoint");
		//是否有经停
		String success = WebServiceUtils.getContentForXPath(resultXml, "Success");
		//System.out.println(success);
		//到达机场信息
		String endPoint = WebServiceUtils.getContentForXPath(resultXml, "EndPoint");
		
		if("0".equals(success)){
			System.out.println("没有经停信息");
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
