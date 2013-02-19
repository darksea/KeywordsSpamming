本项目简介
	提供GIT中国完成文章发帖关键字过滤功能、同时免费提供该服务
本项目技术架构设计
	采用主流的REST面向服务面向组件的架构设计思想下采用SpringMVC的REST技术实现规范的实现。
	SpringMVC+Maven+Git(版本控制)
	
本项目参考相关的技术文档
	http://www.ibm.com/developerworks/web/library/wa-restful/
	http://www.ibm.com/developerworks/web/library/wa-spring3webserv/index.html
引用第三方
https://github.com/gitchina/alex-word-filter
本项目架构及其版本1.0的实现细节方式
主要功能：
	功能一
	完成关键字过滤服务采用目前主流的REST的架构方式将应用层和关键字过滤进行合理的
解耦设计。
          客户端
          应用层（接口调用方）只需要将需要处理的字符串以REST的方式进行POST方式提供到该服务接口
完成关键字过滤功能（提交参数为JSON格式暂定为“字符串”、“替换符号”）
	服务端
	返回过滤结果（警告级、屏蔽后内容、过滤掉的敏感字符串、原始内容）然后应用层那到结果做其
它业务处理
技术要求：
	了解springmvc git maven hao
招募贡献：
	协同于github（只有一个github账号即可）fork pull request
贡献地址：https://github.com/gitchina/KeywordsSpamming

畅        想：
	gitchina.org将对外提供该服务，开放源代码提供给个人或企业搭建该服务









