package com.balance.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.balance.dto.ChatMessage;

@Controller
public class ChatController {

	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		System.out.println("SendMessage : "+chatMessage.toString() );
		return chatMessage;
	}
	
	@MessageMapping("chat.addUser")
	@SendTo("topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor header) {
		
		System.out.println("addUser\n"+ chatMessage+","+header);
		System.out.println("-------------------");
		System.out.println("Null찾기 "+chatMessage.getSender());
		System.out.println("ChatController - "+chatMessage.getTime());
		header.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	
	
	
}
