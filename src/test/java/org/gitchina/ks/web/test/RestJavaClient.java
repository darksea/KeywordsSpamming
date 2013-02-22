package org.gitchina.ks.web.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.mortbay.log.Log;

 


 
public class RestJavaClient {
	
		private Logger log = Logger.getLogger(getClass());
		 
		/**
		 * RestFul的请求地址URL
		 */
		private String hostURl;
		/**
		 * 采用HTTP BASIC AUTHENTICATION 加密帐号
		 */
		private String userName;
		
		/**
		 * 采用HTTP BASIC AUTHENTICATION 加密密码
		 */
		private String passwd;
		
		
		
		
		 /**
		 * @Title:        MessageAletsByJavaClient
		 * @Description:    TODO(完成客户端基本参数设置建议第三方将URL写入配置文件)
		 * @param:    @param hostURl 请求URL 
		 * @param:    @param userName 请求用户名
		 * @param:    @param passwd 请求验证密码
		 * @throws
		 */
		public RestJavaClient(String hostURl, String userName,
				String passwd) {
			super();
			this.hostURl = hostURl;
			this.userName = userName;
			this.passwd = passwd;
		}

			/**
			 * 
			 * @Title: sendMessageInfoByPost
			 * @Description: TODO(使用该工具类下需要手动将{@code SendInfoMessage}所用需要配置的字段
			  * 一定必须SET相应的参数（短信内容、业务类型、手机号）)
			 * @param: @param sendInfoMessage
			 * @param: @return   
			 * @return: String  success(成功) error（失败）
			 * @throws
			 */
		public  String sendMessageInfoByPost(Object object){
			String output = "error";
			String s;
			 try {
				  
					String authString = this.userName + ":" + this.passwd;
					Log.info("auth string: " + authString);
					byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
					String authStringEnc = new String(authEncBytes);
					Log.info("Base64 encoded auth string: " + authStringEnc);
				//接口URL
					URL url = new URL(this.hostURl);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Type", "application/json");
					conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
				//将短信内容转换为JSON字符串进行转码
					String jsonString=JsonUtils.toJson(object);
					Log.info(jsonString);
					//
					OutputStream os = conn.getOutputStream();
					os.write(jsonString.getBytes());
					os.flush();
					Log.info(""+conn.getResponseCode());
				
			 
					BufferedReader br = new BufferedReader(new InputStreamReader(
							(conn.getInputStream())));
			 
					
					System.out.println("Output from Server .... \n");
				
					while (( s= br.readLine()) != null) {
						 	output= s;
					}
			 
					conn.disconnect();
			 
				  } catch (MalformedURLException e) {
			 
					e.printStackTrace();
			 
				  } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return output;  
			}


		 

		
 
		
		
}
