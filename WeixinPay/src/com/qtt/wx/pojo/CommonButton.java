package com.qtt.wx.pojo;

import com.qtt.wx.util.UrlUtil;

/**
 * 普通按钮(子按钮)
 * @author cdw
 *
 */
public class CommonButton extends Button {  
    private String type;  
    private String key;  
    private String url;  
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getKey() {  
        return key;  
    }  
    
    public void setKey(String key) {  
        this.key =  key;
    }
    
	public String getUrl() {
		return url;
	}
	
	/**
	 * 这里进行一下重要的处理(为了微信网页的授权)
	 * @param url
	 */
	public void setUrl(String url) {
		if(url != null){
			this.url = UrlUtil.getCode(url);
		}else{
			this.url = url ;
		}
	}  
    
}  