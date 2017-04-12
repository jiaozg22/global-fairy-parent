package org.global.fairy.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动dubbo容器!
 * 
 */
public class App {
	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "global-fairy-dubbo-provider.xml" });

		context.start();

		System.out.println("Press any key to exit.");

		System.in.read();

	}
}
