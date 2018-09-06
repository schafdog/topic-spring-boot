package com.schafroth.app.topic;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.TestCase;

public class ApplicationTest extends TestCase {
	
	/* Implement */
	
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private TopicReplyRepository topicReplyRepository;

	public void init(String... strings) throws Exception {
		// save a couple of categories
		Set<Topic> topics = new HashSet<Topic>();
		
		for (int index = 0; index < 3; index++) {
			final Topic topic = new Topic("Topic " + index, "email " + index, "body " + index);
			topicRepository.save(topic);
			Set<TopicReply> replies = new HashSet<TopicReply>() {
				private static final long serialVersionUID = 1L;
	
				{
					TopicReply reply = new TopicReply("email 1", "reply", topic);
					add(reply);
					reply = new TopicReply("Email 2", "reply", topic);
					add(reply);
					reply = new TopicReply("Email 3", "reply", topic); 
					add(reply);
				}
			};
			topicReplyRepository.saveAll(replies);
			topic.setTopicReplies(replies);
			topicRepository.save(topic);
			topics.add(topic);
		}

		// fetch all topics
		int count = 0;
		for (Topic aTopic : topicRepository.findAll()) {
			Application.logger.info(aTopic.toString());
			assertTrue("Missing topic", topics.contains(aTopic));
			count++;
		}
		assertTrue("Wrong number of topics", topics.size() == count);
	}


}
