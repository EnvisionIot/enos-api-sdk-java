package com.envision.eeop.api.request;

import java.util.List;

public class MessageDataRequest {
	public List<String> users = null; //号码列表
	public String msg = null;                  //短信内容
	@Override
	public String toString() {
		return "[users=" + users + ", msg=" + msg + "]"; 
	}
	
	
}
