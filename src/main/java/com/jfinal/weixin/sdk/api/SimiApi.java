package com.jfinal.weixin.sdk.api;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfinal.kit.HttpKit;

public class SimiApi {

    public static String simiUrl = "";
    public static String simiKey = "";
    public static String simiLc = "ch";
    public static String say(String str){
	String res = "helo";
	Map<String, String> map = new HashMap<String, String>();
	map.put("key", simiKey);
	map.put("lc", simiLc);
	map.put("text", str);
	String jsonStr = HttpKit.get(simiUrl,map);
	Map mapResp;
	try {
	    mapResp = new ObjectMapper().readValue(jsonStr, Map.class);
	    res = (String)mapResp.get("response");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    res = "helo";
	}finally{
	    return res;
	}
    }
    

}
