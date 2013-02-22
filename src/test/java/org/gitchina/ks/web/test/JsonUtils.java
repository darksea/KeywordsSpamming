/**
 * 
 */
package org.gitchina.ks.web.test;

import java.io.IOException;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
 
public class JsonUtils {

	private static Logger log = Logger.getLogger(JsonUtils.class);
	private static Gson gson = null;
	/**
	 * 通过单例获取gson
	 * @return
	 */
	public static Gson getGson(){
		if(gson==null){
			return new Gson();
		}
		return gson;
	}

	/**
	 * 把java对象转换为JSON
	 * @param obj 要转换的对象
	 * @return
	 * @throws IOException 
	 */
	public static String toJson(Object obj){
		//getResponse().setContentType("text/html;charset=utf-8");
		return getGson().toJson(obj);
	}
	 
	 
}
