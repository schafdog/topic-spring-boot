package com.schafroth.app.topic;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Topic {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String email;
	private String body;
	private String title;
	@OneToMany(targetEntity=TopicReply.class, mappedBy="topic", fetch=FetchType.EAGER)
	private Set<TopicReply> replies;

	public Topic() {
	}

	public Topic(String topic, String email, String body) {
		this.title = topic;
		this.email = email;
		this.body = body;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String topic) {
		this.title = topic;
	}

    public String getBody() {
        return body;
    }

    public void setBody(String content) {
        this.body= content;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String sender) {
		this.email = sender;
	}
	
    public Set<TopicReply> getTopicReplies() {
        return replies;
    }

    public void setTopicReplies(Set<TopicReply> replies) {
    	this.replies = replies;
    }

}