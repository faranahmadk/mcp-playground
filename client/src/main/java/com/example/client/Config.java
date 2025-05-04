package com.example.client;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  McpSyncClient mcpSyncClient() {
    McpSyncClient mcpSyncClient = McpClient
        .sync(HttpClientSseClientTransport
            .builder("http://localhost:8081")
            .build())
        .build();

    mcpSyncClient.initialize();
    return mcpSyncClient;
  }

  @Bean
  ChatClient chatClient(ChatClient.Builder builder, McpSyncClient mcpSyncClient) {
    return builder
        .defaultToolCallbacks(new SyncMcpToolCallbackProvider(mcpSyncClient))
        .build();
  }
}
