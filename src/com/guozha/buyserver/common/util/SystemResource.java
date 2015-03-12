package com.guozha.buyserver.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemResource {
	
	private static Properties p;
	
	static{
		InputStream inputStream = SystemResource.class.getClassLoader().getResourceAsStream("system.properties");   
		p = new Properties();   
		try {   
		    p.load(inputStream);   
		} catch (IOException e1) {   
		    e1.printStackTrace();   
		}
	}
	
	public static String getConfig(String key) {
		return p.getProperty(key);
	}

}
