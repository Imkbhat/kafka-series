package com.luv2codeinjava.kafka.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.luv2codeinjava.kafka.model.User;

@Service
public class KafkaConsumer {
	
	//Whenever there is msg in Kafka topic, this listener will help in
	//direct access of that msg
	//we can pass array of topics to get msg from specified topics
	//group id to identify specific topic from that group, as we 
	//can create same topic name in other groups
	
	@KafkaListener(topics = "Kafka-Example", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed message "+message);
	}
	
	@KafkaListener(topics = "Kafka-Example", groupId = "group_id")
	public void consumeJson(User user) {
		System.out.println("Consumed message "+user);
	}

}
