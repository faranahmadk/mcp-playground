package com.example.client;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gemini/")
public class ChatController {
  private final ChatService service;

  public ChatController(ChatService service) {
    this.service = service;
  }

  @PostMapping("/chat")
  public ChatResponse chat(@RequestBody String msg) {
    return new ChatResponse(this.service.chat(msg));
  }
}
