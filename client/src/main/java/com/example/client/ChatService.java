package com.example.client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

  @Autowired
  ChatClient chatClient;

  public String chat(String msg) {
    String content = this.chatClient
        .prompt()
        .system("You are an AI powered Scheduling Assistant")
        .user(msg)
        .call()
        .content();

    return content;
  }
}
