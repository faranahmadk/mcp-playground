package com.example.server;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class Scheduler {

  private List<Course> courses = new ArrayList<>();

  @Tool(description = "schedule an appointment")
  public String scheduleAppointment(
      @ToolParam(description = "name") String name,
      @ToolParam(description = "email") String email) {

    // schedule
    System.out.printf("Scheduling appointment for %s having email %s", name, email);

    // send
    return Instant
        .now()
        .plus(2, ChronoUnit.DAYS)
        .toString();
  }

  @Tool(description = "Get a list of courses")
  public List<Course> getCourses() {
    return courses;
  }

  @PostConstruct
  public void init() {
    courses.addAll(
        List.of(
            new Course("Java Fundamentals", "http://localhost:8080/java1"),
            new Course("Java Advanced", "http://localhost:8080/java2")));
  }

}
