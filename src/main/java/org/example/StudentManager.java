package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class StudentManager {
  private final List<Student> students = new ArrayList<>();
  private static final List<String> subjects = List.of("数学", "英語", "理科", "社会", "国語");

  // 学生を追加（点数も入力可能）
  public void addStudent(String name, Scanner scanner) {
    Student student = new Student(name);
    students.add(student);
    System.out.println("学生が追加されました。");

    // 追加時に点数入力
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

  // 平均点の計算
  public void printAverageScore() {
    if (students.isEmpty()) {
      System.out.println("学生が登録されていません。");
      return;
    }

    OptionalDouble average = students.stream()
        .flatMapToDouble(s -> s.getSubjects().values().stream().mapToDouble(Integer::doubleValue))
        .average();

    System.out.println("全学生の平均点: " + (average.isPresent() ? average.getAsDouble() : 0.0));
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
