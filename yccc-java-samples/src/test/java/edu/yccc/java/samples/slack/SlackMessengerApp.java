package edu.yccc.java.samples.slack;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yccc.java.samples.slack.SlackService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SlackMessengerApp {
	
	@Autowired
	SlackService slackService = new SlackService();
	
	@Test
	public void testSendMessage(String username, String channel, String message)
	{
		slackService.sendMessage(channel, username, message);
	}


}
