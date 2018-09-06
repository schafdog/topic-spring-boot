package com.schafroth.app.topic.messaging;

import com.schafroth.app.topic.ReplyEmail;

public interface MailClient {

	void deliver(ReplyEmail replyEmail);
}
