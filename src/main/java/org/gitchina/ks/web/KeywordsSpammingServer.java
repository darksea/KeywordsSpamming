package org.gitchina.ks.web;

import org.apache.log4j.Logger;
import org.gitchina.ks.dto.KeywordsQuery;
import org.gitchina.wordfiter.WordFilterUtil;
import org.gitchina.wordfiter.result.FilteredResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @ClassName:     KeywordsSpammingServer
 * @Description:TODO(提供上层服务调用进行关键字过滤)
 * @author:    Chivalrous
 * @date:        2013-2-19 下午2:01:11
 */
@Controller
@RequestMapping("/ks")
public class KeywordsSpammingServer {
	
	private static final Logger log = Logger.getLogger(KeywordsSpammingServer.class);
	/**
	 * 
	 * @Title: filteringMaliciousKeyWords
	 * @Description: TODO(过滤方法)
	 * @param: @param KeyWords 需要过滤的字符串
	 * @param: @return  返回已过滤的数据的相关参数
	 * @return: FilteredResult   
	 * @throws
	 */
	@RequestMapping(value = "/filteringMaliciousKeyWords", method = RequestMethod.POST)
	public @ResponseBody FilteredResult filteringMaliciousKeyWords(@RequestBody KeywordsQuery keywords  ) {
		FilteredResult fr = null;
		try {
			fr =WordFilterUtil.filterHtml(keywords.getOriginString(), keywords.getReplacement());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return fr;
	}
}
