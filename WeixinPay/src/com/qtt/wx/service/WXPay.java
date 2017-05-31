package com.qtt.wx.service;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.qtt.wx.pojo.CallBack;
import com.qtt.wx.pojo.OrderReq;
import com.qtt.wx.pojo.OrderResp;
import com.qtt.wx.util.CMyUtils;
import com.qtt.wx.util.SSLClient;
import com.qtt.wx.util.parseUtil;

import net.sf.json.JSONObject;
/**
 * 用于微信支付的处理类
 * @author cdw
 *
 */
public class WXPay {
	//获取预支付id
	public String getPrepay_id(String body, String detail, String attach, String total_fee, String spbill_create_ip,
			String openid) throws Exception {
		String key = "KEY";
		OrderReq orderReq = new OrderReq();
		orderReq.setAppid("APPID");
		orderReq.setMch_id("1391209702");
		String str = UUID.randomUUID().toString();
		String replace = str.replace("-", "");
		orderReq.setNonce_str(replace);
		orderReq.setBody(body);
		orderReq.setDetail(detail);
		orderReq.setAttach(attach);
		String out_trade_no = CMyUtils.getNumTime();
		System.out.println(out_trade_no);
		orderReq.setOut_trade_no(out_trade_no);
		orderReq.setTotal_fee(total_fee);
		orderReq.setSpbill_create_ip(spbill_create_ip);
		orderReq.setNotify_url("http://www.XXX.com/XXX/callback.jsp");
		orderReq.setTrade_type("JSAPI");
		orderReq.setOpenid(openid);
		String[] arr = new String[] { "appid", "mch_id", "nonce_str", "body", "detail", "attach", "out_trade_no",
				"total_fee", "spbill_create_ip", "notify_url", "trade_type", "openid" };
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		Class<?> c = Class.forName("qtt.wx.pojo.OrderReq");
		for (String string : arr) {
			sb.append(string);
			sb.append("=");
			String methodName = "get" + string.substring(0, 1).toUpperCase() + string.substring(1);
			Method method = c.getMethod(methodName);
			String str2 = (String) method.invoke(orderReq);
			sb.append(str2);
			sb.append("&");
		}
		String content1 = sb.toString();
		
		System.out.println(content1);
		System.out.println(content1 + "key=" + key);
		String sign = CMyUtils.GetMD5(content1 + "key=" + key);
		orderReq.setSign(sign);
		String orderReqToXml = parseUtil.toXml(orderReq);
		System.out.println(orderReqToXml);
		String replace2 = orderReqToXml.replace("__", "_");// 处理一个bug
		System.out.println(replace2);
		// https://api.mch.weixin.qq.com/pay/unifiedorder
		HttpClient httpClient = new SSLClient();
		HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder");
		StringEntity entity = new StringEntity(replace2, "utf-8");
		httpPost.setEntity(entity);
		HttpResponse result = httpClient.execute(httpPost);
		String resData = EntityUtils.toString(result.getEntity());
		String string = new String(resData.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("处理结果：" + string);
		System.out.println("解析开始....");
		System.out.println();
		OrderResp orderResp = parseUtil.toBean(string, OrderResp.class);
		String prepay_id = orderResp.getPrepay_id();
		System.out.println("prepay_id结果：" + prepay_id);
		return prepay_id;
	}
	
	//下单参数处理，生成微信h5支付参数
	public String handleParam(String data){
		String key = "KEY";
		String appId = "APPID";
		String timeStamp = Long.toString(System.currentTimeMillis()); 
		String nonceStr = UUID.randomUUID().toString().replace("-", "");
		String prepay_id = "prepay_id="+data;
		String signType = "MD5";
		TreeMap<String, String> params = new TreeMap<String, String>();
		params.put("appId", appId);
		params.put("timeStamp", timeStamp);
		params.put("nonceStr", nonceStr);
		params.put("package", prepay_id);
		params.put("signType", signType);
		StringBuffer sb = new StringBuffer();
		Iterator<Entry<String, String>> it = params.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			String k = entry.getKey();
			String v = entry.getValue();
			sb.append(k);
			sb.append("=");
			sb.append(v);
			sb.append("&");
		}
		String sstring = sb.toString();
		String paySign  = CMyUtils.GetMD5(sstring+"key="+key);
		params.put("paySign", paySign);
		JSONObject jsonObject = JSONObject.fromObject(params);
		System.out.println(jsonObject);
		return jsonObject.toString();
	}
	
	//回调结果处理
	public String callBack(InputStream inputStream){
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(inputStream);
			String asXML = document.asXML();
			System.out.println(asXML);
			System.out.println();
			System.out.println();
			CallBack callBack = parseUtil.toBean(asXML, CallBack.class);
			System.out.println(callBack);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	public static void main(String[] args) {
		WXPay wxPay = new WXPay();
		wxPay.handleParam("dasdasd");
	}
}
