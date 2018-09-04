package com.schafroth.app.topic;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TopicController {
	public static List<Topic> topics = new LinkedList<Topic>();
	public static Map<Topic, List<TopicReply>> replies = new HashMap<Topic, List<TopicReply>>();

	Logger logger = LoggerFactory.getLogger(TopicController.class);

	@GetMapping("/topic/new")
	public String topicForm(Model model) {
		model.addAttribute("topic", new Topic());
		return "topic";
	}

	@GetMapping("/topic")
	public String topics(Model model) {
		model.addAttribute("topics", topics);
		return "result";
	}

	@PostMapping("/topic")
	public String topicSubmit(@ModelAttribute Topic topic, Model model) {
		/* Validate and persist new topic before showing result */
		synchronized (topics) {
			topic.setId(topics.size());
			topics.add(topic);
		}
		model.addAttribute("topics", topics);

		return "redirect:/topic";
	}

	@GetMapping("/topic/{id}/reply")
	public String topicReplyForm(@PathVariable int id, Model model) {
		TopicReply reply = new TopicReply();
		reply.setTopic(topics.get(id));
		model.addAttribute("reply", reply);
		return "topic_reply";
	}

	@PostMapping("/topic/{id}/reply")
    public String replySubmit(@PathVariable int id, @ModelAttribute TopicReply reply, Model model) 
    {
    	/* Validate and persist new topic before showing result */
    	List<TopicReply> topicReplies; 
    	Set<String> emailSet = new LinkedHashSet<String>();
    	Topic topic = topics.get(id);
    	if (topic != null) {
    		// Update/persist 
    		synchronized (replies) {
    			topicReplies = replies.get(topic);
    			if (topicReplies == null) { 
    				topicReplies = new LinkedList<TopicReply>();
    			}
    			topicReplies.add(reply);
				replies.put(topic, topicReplies);
    		}
        	// Send email to topic email and all (except current) but only once!
        	// Use Set<email>
    		emailSet.add(topic.getEmail());
    		for (TopicReply aReply : topicReplies) {
    			if (!reply.getEmail().equals(aReply.getEmail()))
    				emailSet.add(aReply.getEmail());
    		}
    	   	// For worker thread or queue
        	logger.info("Send email about " + reply.getReply() + " to " + emailSet.size() + " users with reply " + " from " + reply.getEmail());
    	}
    	else {
    		logger.error("Failed to get correct topic and user to send " + reply.getReply() + " from " + reply.getEmail());
    	}
    	model.addAttribute("topics", topics);
    	return "redirect:/topic";
    }

}