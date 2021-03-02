package com.balance.dto;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class ChatMessage {

	private MessageType type;
	private String content;
	private String sender;
	private String time;
}
