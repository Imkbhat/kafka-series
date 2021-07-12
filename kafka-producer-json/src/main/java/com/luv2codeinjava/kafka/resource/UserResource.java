package com.luv2codeinjava.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2codeinjava.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {
	
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "Kafka-Example";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		
		kafkaTemplate.send(TOPIC, new User(name,"Tech", 2000L));
		return "Producer Published Successfully.";
	}
	

}
