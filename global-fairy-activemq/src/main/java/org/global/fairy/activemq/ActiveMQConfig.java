package org.global.fairy.activemq;

public class ActiveMQConfig {
	public static final String activeMQ_host_protocal = "tcp";
	public static final String activeMQ_host_ip = "localhost";
	public static final String activeMQ_host_port = "61616";

	public static String activeMQ_url = activeMQ_host_protocal + "://"
			+ activeMQ_host_ip + ":" + activeMQ_host_port;
}
