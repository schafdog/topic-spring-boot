package com.schafroth.app.topic.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schafroth.app.topic.ReplyEmail;
import com.schafroth.app.topic.ReplyEmailSender;

@RestController
@RequestMapping("/transaction")
@Profile("Step6") 
public class ReplyEmailSenderJMS implements ReplyEmailSender
{
  @Autowired private JmsTemplate jmsTemplate;

  @PostMapping("/send")
  public void send(@RequestBody ReplyEmail replyEmail) {
    System.out.println("Queuing a reply email.");
    // Post message to the message queue named "OrderTransactionQueue"
    jmsTemplate.convertAndSend("ReplyEmailQueue", replyEmail);
  }
}