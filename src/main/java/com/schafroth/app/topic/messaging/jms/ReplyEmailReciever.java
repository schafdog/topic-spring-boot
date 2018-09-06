package com.schafroth.app.topic.messaging.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.schafroth.app.topic.ReplyEmail;
import com.schafroth.app.topic.messaging.MailClient;
@Component
public class ReplyEmailReciever {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReplyEmailReciever.class);

	@Autowired
	private MailClient smtpClient;

	@JmsListener(destination = "ReplyEmailQueue")
	public void receiveMessage(ReplyEmail replyEmail) {
		LOGGER.info("Received " + replyEmail + "for SMTP delivering");
		smtpClient.deliver(replyEmail);
	}
}