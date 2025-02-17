package org.example;

import java.util.HashMap;
import java.util.Map;

public class Student {
  private String name;
  private final Map<String, Integer> subjects;

  public Student(String name) {
    this.name = name;
    this.subjects = new HashMap<>();
  }

  public String getName() {
    return name;
  }

  public Map<String, Integer> getSubjects() {
    return subjects;
  }

  public void setScore(String subject, int score) {
    subjects.put(subject, score);
  }

  public Integer getScore(String subject) {
    return subjects.getOrDefault(subject, null);
  }

  public double getAverageScore() {
    return subjects.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("名前: " + name + ", 点数: ");
    subjects.forEach((subject, score) -> result.append(subject).append(": ").append(score).append(", "));
    return result.toString();
  }
}
