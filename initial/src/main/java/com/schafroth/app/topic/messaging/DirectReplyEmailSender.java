package com.schafroth.app.topic.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.schafroth.app.topic.ReplyEmail;
import com.schafroth.app.topic.ReplyEmailSender;

@Component
@Profile("!Step6")
public class DirectReplyEmailSender implements ReplyEmailSender {
	@Autowired
	private MockMailClient mailClient;
	@Override
	public void send(ReplyEmail replyEmail) {
		mailClient.deliver(replyEmail);

	}

}
