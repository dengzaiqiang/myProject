package interfaceInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.junit.Test;

import com.qh.apply.ApplyParam;
import com.qh.apply.ApplyParams;
import com.qh.ffInfo.Param;
import com.qh.ffInfo.Params;
import com.qh.login.LoginInfo;
import com.qh.pat.PatParam;
import com.qh.pat.PatParams;
import com.qh.pay.PayParam;
import com.qh.pay.PayParams;
import com.qh.policy.PolicyParam;
import com.qh.policy.PolicyParams;
import com.qh.reserve.CPassengerCardInfo;
import com.qh.reserve.CPassengerInfo;
import com.qh.reserve.FlightTrip;
import com.qh.reserve.FlightTrips;
import com.qh.reserve.PassengerCardInfos;
import com.qh.reserve.PassengerInfos;
import com.qh.search.SearchParam;
import com.qh.search.SearchParams;
import com.qh.util.RandomGUIDUtil;
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
		if("".equals(resultXml.trim())){
			throw new RuntimeException("返回结果为空字符串");
		}
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
	private void printResult(String resultContent){
		System.out.println(resultContent);
	}
	/**
	* @Title: payOrder
	* @Description: 支付订单
	* @return void
	 */
	@Test
	public void payOrder(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		
		PayParam param = new PayParam("809612", "JEEXJ6", "792.40");
		PayParams params = new PayParams(param);
		linkedMap.put("paramsXml",WebServiceUtils.beanToXml(params, PayParams.class));
		
		printResult(getReturnString("PayOrderNew",linkedMap,RESULT));
	}
	
	
	
	/**
	* @Title: getApplyProvision
	* @Description: 获取舱位退改签规定
	* @return void
	 */
	@Test
	public void getApplyProvision(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		
		ApplyParam param = new ApplyParam("CZ", "", "Y");
		ApplyParams params = new ApplyParams(param);
		linkedMap.put("paramsXml", WebServiceUtils.beanToXml(params, ApplyParams.class));
		
		printResult(getReturnString("GetApplyProvision",linkedMap,RESULT));
	}
	
	
	/**
	* @Title: applyBlankOutTicket
	* @Description: 退票
	* @return void
	 */
	@Test
	public void applyBlankOutTicket(){
		
	}
	
	/**
	* @Title: searchOrderDetail
	* @Description: 查询订单详情
	* @return void
	 */
	@Test
	public void searchOrderDetail(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		linkedMap.put("OrderID", "809612");
		
		String resultContent = getReturnString("SearchOrderDetail", linkedMap, RESULT);
		System.out.println( resultContent);
		
	}
	
	
	/**
	* @Title: searchOrder
	* @Description: 查询订单
	* @return void
	 */
	@Test
	public void searchOrder(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		
		SearchParam param = new SearchParam("JM1WFX", "", "", "", "", "", "1", "5");
		SearchParams params = new SearchParams(param);
		linkedMap.put("ParamsXml", WebServiceUtils.beanToXml(params, SearchParams.class));
		
		String resultContent = getReturnString("SearchOrder", linkedMap, RESULT);
		System.out.println( resultContent);
	}
	
	/**
	* @Title: patPolicyByPnr
	* @Description: 导入PNR匹配 政策以及航班舱位运价
	* @return void
	 */
	@Test
	public void patPolicyByPnr(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		
		PatParam param = new PatParam("JM1WFX", "");
		PatParams params = new PatParams(param);
		System.out.println(WebServiceUtils.beanToXml(params, PatParams.class));
		linkedMap.put("paramsXml", WebServiceUtils.beanToXml(params, PatParams.class));
		
		String resultContent = getReturnString("PatPolicyByPnr", linkedMap, RESULT);
		System.out.println( resultContent);
		
	}
	
	
	/**
	 * 机票预定
	 */
	@Test
	public void reserve(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		//旅客信息
		CPassengerInfo passengerInfo = new CPassengerInfo();
		String pid = RandomGUIDUtil.getRandomGUID();
		passengerInfo.setPid(pid);
		passengerInfo.setPassengerName("李四");
		passengerInfo.setPassengerType("1");
		passengerInfo.setCertifyType("身份证");
		passengerInfo.setCertifCode("429006198911287016");
		
		List<CPassengerInfo> list1 = new ArrayList<CPassengerInfo>();
		list1.add(passengerInfo);
		PassengerInfos passengerInfos = new PassengerInfos(list1);
		
		CPassengerCardInfo passengerInfoCard = new CPassengerCardInfo(pid, "180005348224", "CZ");
		List<CPassengerCardInfo> list2 = new ArrayList<CPassengerCardInfo>();
		list2.add(passengerInfoCard);
		PassengerCardInfos passengerInfoCards = new PassengerCardInfos(list2);
		
		FlightTrip flightTrip = new FlightTrip("CKG","KWE","2014-05-23","CZ3475","M");
		List<FlightTrip> list3 = new ArrayList<FlightTrip>();
		list3.add(flightTrip);
		FlightTrips flightTrips = new FlightTrips(list3);
		
		com.qh.reserve.Param param = new com.qh.reserve.Param();
		param.setPassengerCardInfos(passengerInfoCards);
		param.setPassengerInfos(passengerInfos);
		param.setFlightTrips(flightTrips);
		param.setLinkMan("邓在强");
		param.setLinkTel("18520160743");
		param.setPolicyId(" ");
		param.setReamrk("测试 ");
		com.qh.reserve.Params params = new com.qh.reserve.Params(param);
		//System.out.println(WebServiceUtils.beanToXml(params, com.qh.reserve.Params.class));
		linkedMap.put("paramsXml", WebServiceUtils.beanToXml(params, com.qh.reserve.Params.class));
		String resultContent = getReturnString("Reserve", linkedMap, RESULT);
		System.out.println( resultContent);
		
	} 
	
	/**
	 * 单程政策查询
	 */
	@Test
	public void getSinglePolicyList(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		
		//PolicyParam param = new PolicyParam("2014-04-23", "CANPEK", "CZ","Y", "CZ3107");
		PolicyParam param = new PolicyParam("2014-05-23", "CANPEK", "","", "");
		PolicyParams params = new PolicyParams(param);
		
		linkedMap.put("paramsXml", WebServiceUtils.beanToXml(params, PolicyParams.class));
		
		String resultContent = getReturnString("GetSinglePolicyListV2", linkedMap, RESULT);
		System.out.println( resultContent);
	}
	
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
	 * 查询直达航班（匹配了单程政策）(政策号竟然都没有)
	 */
	@Test
	public void getFlightInfo(){
		Map<String,Object> linkedMap = new LinkedHashMap<String,Object>();
		linkedMap.put("loginXml", WebServiceUtils.beanToXml(new LoginInfo(), LoginInfo.class));
		com.qh.flightInfo.Param param = 
				new com.qh.flightInfo.Param("CAN", "PEK", "2014-04-23", "CZ");
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
