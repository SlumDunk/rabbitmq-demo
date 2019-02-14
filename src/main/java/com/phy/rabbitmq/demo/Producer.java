package com.phy.rabbitmq.demo;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.SerializationUtils;

/**
 * 消息生產者
 * 
 * @author jack_liu
 * 
 */
public class Producer extends EndPoint {

	public Producer(String endpointName) throws IOException, TimeoutException {
		super(endpointName);
		// TODO Auto-generated constructor stub
	}

	public void sendMessage(Serializable object) throws IOException {
		channel.basicPublish("", endPointName, null,
				SerializationUtils.serialize(object));
	}

}
