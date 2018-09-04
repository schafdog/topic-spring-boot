package com.schafroth.app.topic;

public class TopicReply {

    private long id;
    
	private Topic topic;
	private String email;
	private String reply;
	private long topicId;

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

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long id) {
		this.topicId = id;
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