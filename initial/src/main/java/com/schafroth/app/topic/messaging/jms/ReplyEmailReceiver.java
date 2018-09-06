package com.schafroth.app.topic.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.schafroth.app.topic.ReplyEmail;
import com.schafroth.app.topic.messaging.MailClient;

@Component
public class ReplyEmailReceiver {
	@Autowired
	private MailClient smtpClient;

	@JmsListener(destination = "ReplyEmailQueue")
	public void receiveMessage(ReplyEmail replyEmail) {
		System.out.println("Received <" + replyEmail + ">");
		smtpClient.deliver(replyEmail);
	}
}