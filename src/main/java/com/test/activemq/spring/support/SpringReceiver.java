package com.test.activemq.spring.support;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * Spring JMSTemplate 消息接收者
 * 
 * @author gsm02
 *
 */
public class SpringReceiver {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext-*.xml");

		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
		while (true) {
			Map<String, Object> map = (Map<String, Object>) jmsTemplate.receiveAndConvert();

			System.out.println("收到消息：" + map.get("message"));
		}
	}
}