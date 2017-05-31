package com.qtt.wx.util;

import java.io.UnsupportedEncodingException;

//用于处理网页链接的工具类
public class UrlUtil {
	public static String getCode(String url){
		String appid = "wx3978a694c607a49d";
		try {
			url =  java.net.URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			CMyLog.InfoLog("URLEncoder encode发生异常！");
			e.printStackTrace();
			return url;
		}
		String codeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri="
				+ url + "&response_type=code&scope=snsapi_base&state=abc#wechat_redirect";
		return codeUrl;
	}
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		//String code = getCode("");
		//System.out.println(code);
	}
}
