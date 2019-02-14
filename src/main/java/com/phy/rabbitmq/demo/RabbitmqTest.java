package com.phy.rabbitmq.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class RabbitmqTest {
	public RabbitmqTest() throws IOException, TimeoutException {
		// TODO Auto-generated constructor stub
		QueueConsumer consumer = new QueueConsumer("queue");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

		Producer producer = new Producer("queue");

		for (int i = 0; i < 1000000; i++) {
			HashMap message = new HashMap();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number " + i + " sent.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new RabbitmqTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
