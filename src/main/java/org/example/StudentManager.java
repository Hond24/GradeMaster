package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class StudentManager {
  private final List<Student> students = new ArrayList<>();
  private static final List<String> subjects = List.of("数学", "英語", "理科", "社会", "国語");

  // 学生を追加（点数も入力可能）
  public void addStudent(String name, Scanner scanner) {
    Student student = new Student(name);
    students.add(student);
    System.out.println("学生が追加されました。");

    System.out.println("各科目の点数を入力してください（スキップする場合は -1 を入力）。");
    for (String subject : subjects) {
      System.out.print(subject + " の点数: ");
      int score = scanner.nextInt();
      scanner.nextLine(); // 改行を消費
      if (score != -1) {
        student.setScore(subject, score);
      }
    }
  }

  // 学生を削除
  public void removeStudent(String name) {
    students.removeIf(student -> student.getName().equals(name));
    System.out.println(name + "さんが削除されました。");
  }

  // 全科目の点数を順番に入力（スキップ可能）
  public void updateScores(String name, Scanner scanner) {
    for (Student student : students) {
      if (student.getName().equals(name)) {
        System.out.println(name + "さんの各科目の点数を更新します。（スキップする場合は -1 を入力）");
        for (String subject : subjects) {
          System.out.print(subject + " の新しい点数: ");
          int score = scanner.nextInt();
          scanner.nextLine(); // 改行を消費
          if (score != -1) {
            student.setScore(subject, score);
          }
        }
        System.out.println(name + "さんの点数が更新されました。");
        return;
      }
    }
    System.out.println("指定された名前が見つかりませんでした。");
  }

  // 科目ごとの平均点を計算
  public void printSubjectAverages() {
    if (students.isEmpty()) {
      System.out.println("学生が登録されていません。");
      return;
    }

    Map<String, Integer> subjectTotal = new HashMap<>();
    Map<String, Integer> subjectCount = new HashMap<>();

    // 各学生の点数を集計
    for (Student student : students) {
      for (String subject : student.getSubjects().keySet()) {
        int score = student.getScore(subject);
        subjectTotal.put(subject, subjectTotal.getOrDefault(subject, 0) + score);
        subjectCount.put(subject, subjectCount.getOrDefault(subject, 0) + 1);
      }
    }

    // 平均点を計算・表示
    System.out.println("\n各教科の平均点:");
    for (String subject : subjects) {
      if (subjectCount.containsKey(subject)) {
        double average = (double) subjectTotal.get(subject) / subjectCount.get(subject);
        System.out.printf("%s: %.2f\n", subject, average);
      } else {
        System.out.println(subject + ": データなし");
      }
    }
  }

  // 学生一覧を表示
  public void printStudents() {
    if (students.isEmpty()) {
      System.out.println("学生が登録されていません。");
      return;
    }

    System.out.println("\n学生一覧:");
    students.forEach(System.out::println);
  }
}
