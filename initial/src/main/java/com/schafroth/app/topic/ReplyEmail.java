package com.schafroth.app.topic;

public class ReplyEmail {
	
	private String reciever;
	private String sender; 
	private String reply;
	private String topic;

	public ReplyEmail() {
	}

	public ReplyEmail(TopicReply reply, String emailAddress) {
		sender = reply.getEmail();
		this.reply = reply.getReply();
		topic = reply.getTopic().getTitle();
		reciever = emailAddress; 
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getReply() {
		return reply;
	}

	public String getSender() {
		return sender;
	}

	public String getTopic() {
		return topic;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String toString() {
		return String.format("ReplyEmail(topic=%s, sender=%s, reply=%s, reciever=%s)", 
				topic, sender, reply, reciever);
	}
}
