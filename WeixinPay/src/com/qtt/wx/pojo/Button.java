package com.qtt.wx.pojo;

/**
 * 按钮的基类
 * @author cdw
 *
 */
public class Button {  
    private String name;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }

	@Override
	public String toString() {
		return "Button [name=" + name + "]";
	}  
    
}  
