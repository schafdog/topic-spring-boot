package com.schafroth.app.topic;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private TopicReplyRepository topicReplyRepository;

	public void init(String... strings) throws Exception {
		// save a couple of categories
		final Topic topic = new Topic("Topic 1", "email 1", "body 1");
		topicRepository.save(topic);

		Set<TopicReply> replies = new HashSet<TopicReply>() {
			private static final long serialVersionUID = 1L;

			{
				add(new TopicReply("email 1", "reply", topic));
				add(new TopicReply("Email 2", "reply", topic));
				add(new TopicReply("Email 3", "reply", topic));
			}
		};
		topicReplyRepository.saveAll(replies);
		topic.setTopicReplies(replies);
		topicRepository.save(topic);

		Topic topic2 = new Topic("Topic 2", "email 2", "body 2");
		topicRepository.save(topic2);
		replies = new HashSet<TopicReply>() {
			private static final long serialVersionUID = 1L;
			{
				add(new TopicReply("email 1", "reply", topic2));
				add(new TopicReply("Email 2", "reply", topic2));
				add(new TopicReply("Email 3", "reply", topic2));
			}
		};
		topicReplyRepository.saveAll(replies);
		topic2.setTopicReplies(replies);
		topicRepository.save(topic2);

		// fetch all categories
		for (Topic aTopic : topicRepository.findAll()) {
			logger.info(aTopic.toString());
		}
	}
}