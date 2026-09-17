package com.bedrock.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author:BKMUTAI
 */
public class ChatController {
    private final ChatClient chatClient;
    public ChatController(ChatClient.Builder chatClintBuilder){
        this.chatClient = chatClintBuilder.build();
    }
    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message){
        System.out.println("Request receive : "+message);
        return chatClient.prompt(message).call().content();
    };
}

