package com.example.server;

import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  Scheduler scheduler() {
    return new Scheduler();
  }

  @Bean
  MethodToolCallbackProvider methodToolCallbackProvider(Scheduler scheduler) {
    return MethodToolCallbackProvider
        .builder()
        .toolObjects(scheduler)
        .build();
  }

}
