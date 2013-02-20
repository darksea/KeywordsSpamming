package org.gitchina.ks.dto;
/**
 * 
 * @ClassName:     KeywordsQuery
 * @Description:TODO(客户端参数条件)
 * @author:    Chivalrous
 * @date:        2013-2-19 下午2:43:39
 */
public class KeywordsQuery {
	//原始文本
	private String originString;
	//替换为*或其它符号将敏感词语
	private String replacement;

	public String getOriginString() {
		return originString;
	}

	public void setOriginString(String originString) {
		this.originString = originString;
	}

	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}
	
	
	
}
