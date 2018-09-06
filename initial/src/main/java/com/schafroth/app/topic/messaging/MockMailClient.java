package com.schafroth.app.topic.messaging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.schafroth.app.topic.ReplyEmail;

@Component
@Profile("!Step6")
public class MockMailClient implements MailClient {

	@Override
	public void deliver(ReplyEmail replyEmail) {
		// Formatting response for mock delivery...
		String message = String.format("notification on topic %s from %s reply %s to %s \n",  
				replyEmail.getTopic(), replyEmail.getSender(), replyEmail.getReply(),
				replyEmail.getReciever());
		
		File file = new File("mail.log");
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileOutputStream(file, true));
			writer.printf(message);
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println("Failed to deliver: " + message);
			e.printStackTrace();
		}
	}
}
