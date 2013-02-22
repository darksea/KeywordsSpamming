package org.gitchina.ks.web;

import org.gitchina.ks.dto.KeywordsQuery;
import org.gitchina.ks.web.test.RestJavaClient;
import org.junit.Test;
import org.mortbay.log.Log;

public class KeywordsSpammingServerTest {
	
	@Test
	public void test(){
		RestJavaClient rj = new RestJavaClient("http://localhost:8080/gitchina/rest/ks/filteringMaliciousKeyWords", "mkyong", "123456");
		KeywordsQuery kq = new KeywordsQuery();
		kq.setOriginString("黄色网站中国人民");
		kq.setReplacement('*');
		Log.info(rj.sendMessageInfoByPost(kq));
	}
}
