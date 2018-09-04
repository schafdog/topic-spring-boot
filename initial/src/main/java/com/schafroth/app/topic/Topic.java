package com.schafroth.app.topic;

public class Topic {

    private long id;
	private String topic;
	private String email;
	private String body;

	public Topic() {
	}

	public Topic(int id, String topic, String email, String body) {
		this.id = id;
		this.topic = topic;
		this.email = email;
		this.body = body;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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
}