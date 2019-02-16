package com.lee.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder; 


public class GenSign {

	public static void main(String[] args) {
		
		//https://openapiv2.yilan.tv/video/play?udid=5459daf640bdb6a6a7e294a5f3f5f0d1&ver=1.5.3.224&model=COL-AL10&ip=1.202.240.202&access_key=ylx36jukc8oq&format=json&platform=qmtt&timestamp=1550235889408&id=lm5lG1kXxjp2&
		//sign=Jm83EmSJpNGERk3%2FV%2BVIyxBLOEf%2BGeCOSTIdomI7h7U%3D
		Map<String, String> map = new HashMap();
		map.put("udid", "5459daf640bdb6a6a7e294a5f3f5f0d1");
		map.put("ver", "1.5.3.224");
		map.put("model", "COL-AL10");
		map.put("ip", "1.202.240.202");
		map.put("access_key", "ylx36jukc8oq");
		map.put("format", "json");
		map.put("platform", "qmtt");
		map.put("timestamp", "1550235889408");
		map.put("id", "lm5lG1kXxjp2");
		
		String sign = getSign(map, "/video/play", "ow5um6c233cax89dyuaqzh3g3l4duxdx");
		System.out.println(sign);
		
	}
	
	
	public static String getSign(Map data, String path, String accessToken) {
	  
		TreeSet<String> sortSet = new TreeSet<>();
	    sortSet.addAll(data.keySet());
	    StringBuilder builder = new StringBuilder(path);
	    if (sortSet != null) {
	        for (String key : sortSet) {
	            builder.append(key + data.get(key));
	        }
	    }
	    String sign = "";
	    try {
	        sign = sdkDecode(accessToken + data.get("timestamp"), builder.toString().trim());  
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return sign;
	}

	public static String sdkDecode(String secret,String data) throws Exception {
	    try {
	        SecretKey secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HMACSHA256");
	        Mac mac = Mac.getInstance("HmacSHA256");
	        mac.init(secretKey);
	        byte[] bytes = mac.doFinal(data.getBytes("UTF-8"));
	        BASE64Encoder encoder = new BASE64Encoder();   
	        String encodedString = encoder.encode(bytes);
	        return encodedString.trim();
	    } catch (Exception gse) {
	        throw new Exception("sdkDecode fail", gse);
	    }

	}
}
