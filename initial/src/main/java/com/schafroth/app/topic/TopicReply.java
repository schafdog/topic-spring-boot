package com.schafroth.app.topic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class TopicReply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String email;
	private String reply;
    @ManyToOne
    @JoinColumn(name = "topic_id")
	private Topic topic;

	public TopicReply() {
    };

    public TopicReply(String email, String reply, Topic topic) {
    	this.email = email;
    	this.reply = reply;
    	this.topic = topic;
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Topic getTopic() {
		return topic;
	}

    public String getReply() {
        return reply;
    }

    public void setReply(String content) {
        this.reply= content;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String sender) {
		this.email = sender;
	}
}