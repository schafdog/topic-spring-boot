package com.schafroth.app.topic;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import junit.framework.TestCase;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest extends TestCase {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private TopicReplyRepository topicReplyRepository;

	@Test
	public void testPersist() throws Exception {
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

		// See if all topics are in repo
		for (Topic aTopic : topics) {
			Application.logger.info(aTopic.toString());
			assertTrue("Missing topic", topicRepository.existsById(aTopic.getId()));
			topicRepository.delete(aTopic);
		}
	}
}
