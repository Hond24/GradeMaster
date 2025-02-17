package org.example;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StudentManager manager = new StudentManager();
    boolean running = true;

    while (running) {
      System.out.println("\n学生管理プログラム:");
      System.out.println("1. 学生の追加");
      System.out.println("2. 学生の削除");
      System.out.println("3. 全科目の点数を更新");
      System.out.println("4. 教科ごとの平均点を計算");
      System.out.println("5. 学生一覧の表示");
      System.out.println("6. 終了");
      System.out.print("選択してください (1-6): ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // 改行を消費

      switch (choice) {
        case 1 -> { // 学生の追加
          System.out.print("追加する学生の名前を入力してください: ");
          String name = scanner.nextLine();
          manager.addStudent(name, scanner);
        }
        case 2 -> { // 学生の削除
          System.out.print("削除する学生の名前を入力してください: ");
          String name = scanner.nextLine();
          manager.removeStudent(name);
        }
        case 3 -> { // 点数の更新（全科目）
          System.out.print("点数を更新する学生の名前を入力してください: ");
          String name = scanner.nextLine();
          manager.updateScores(name, scanner);
        }
        case 4 -> manager.printSubjectAverages(); // 教科ごとの平均点を計算
        case 5 -> manager.printStudents(); // 学生一覧の表示
        case 6 -> { // 終了
          running = false;
          System.out.println("プログラムを終了します。");
        }
        default -> System.out.println("無効な選択です。もう一度入力してください。");
      }
    }

    scanner.close();
  }
}
