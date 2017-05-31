package com.qtt.wx.util;

import java.io.UnsupportedEncodingException;

/**
 * 用于菜单绑定url的处理
 * @author cdw
 *
 */
public class UrlUtil {
	public static String getCode(String url){
		String appid = "APPID";
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
