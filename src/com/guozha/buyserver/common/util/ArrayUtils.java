package com.guozha.buyserver.common.util;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.imageio.stream.FileImageOutputStream;


/**
 * <strong>ArrayUtils</strong><br>
 * <br> 
 * <strong>Create on : 2011-12-27<br></strong>
 * <p>
 * <strong>Copyright (C) Ecointel Software Co.,Ltd.<br></strong>
 * <p>
 * @author peng.shi peng.shi@ecointel.com.cn<br>
 * @version <strong>Ecointel v1.0.0</strong><br>
 */
public class ArrayUtils {
	
	private ArrayUtils(){}
	
	/**
	 * 将一个array转为根据keys转为map
	 * @param array
	 * @param keys
	 * @return
	 */
	@SuppressWarnings("all")
	public static Map toMap(Object[] array,String...keys) {
		if(array == null) return new HashMap();
		Map m = new LinkedHashMap();
		for(int i = 0; i < keys.length; i++) {
			if(array.length == i ) {
				break;
			}
			m.put(keys[i], array[i]);
		}
		return m;
	}
	
	/**
	 * 字符数组转int数组，并排序
	 * @param arrays
	 * @return
	 */
	public static int [] toIntArray(String [] arrays){
		int [] array ={arrays.length};
		for(int i=0;i<arrays.length;i++){
			array[i] = Integer.valueOf(arrays[i]);
		}
		Arrays.sort(array);
		return array;
	}
	
	/** 
     * 对象转数组 
     * @param obj 
     * @return 
     */  
	public static byte[] toByteArray(byte[] bytes){
		if(bytes==null){
			return null;
		}
        byte2image(bytes, "E:\\maicai\\jd.png");
        return bytes;   
	}
	
	 public static void byte2image(byte[] data,String path){
		    if(data.length<3||path.equals("")) return;
		    try{
		    	File file = new File(path);
		    	if(!file.isFile()){
		    		file.createNewFile();
		    	}
		    FileImageOutputStream imageOutput = new FileImageOutputStream(file);
		    imageOutput.write(data, 0, data.length);
		    imageOutput.close();
		    System.out.println("Make Picture success,Please find image in " + path);
		    } catch(Exception ex) {
		      System.out.println("Exception: " + ex);
		      ex.printStackTrace();
		    }
		}
	
}
