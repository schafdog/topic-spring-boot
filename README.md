# topic-spring-boot
Simple Topic application in springboot

Implementing the forum exercise

I have choosen Spring-boot framework with mysql and hibernate as basis. It's my first application with springboot. 
I wanted to learn it. 

Step 1 and Step 4 was implemented as one. I have skipped implementing a view of Replies.

Step 2 was implemented using mysql and hibernate.

Step 3 was implemented last.

Step 5 was implemented with DirectReplyEmailSender that implements a interface ReplyMailSender. 
Run without spring profile "Step6" to use this implementation

Step 6 was implemented using JMS messages and using a embedded ActiveMQ. The class ReplyEmailSenderJMS 
also implements the above interface. Using spring profile "Step6" will enable this. 

I will have the application running on my own servers.

b

