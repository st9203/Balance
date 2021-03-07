package com.balance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS();
		
		/*
		 * withSockJS 는 웹소켓을 지우너하지 않는 웹 브라우저에 
		 * 풀백옵션을 황성화하는데 사용합니다.
		 */
	
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
	
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
		
	}
	
}
