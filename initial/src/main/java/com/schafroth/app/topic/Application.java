package com.schafroth.app.topic;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	List<Topic> topics = TopicController.topics;  
    	for (int index = 0 ; index < 5; index++) { 
    		Topic newTopic = new Topic(topics.size(),"Topic " + index, "email" + index, "Body " + index  );
    		topics.add(newTopic);
    	}
        SpringApplication.run(Application.class, args);
    }

}