package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> scores = new ArrayList<>();
    boolean running = true;

    while (running) {
      System.out.println("\n学生管理プログラム:");
      System.out.println("1. 学生の追加");
      System.out.println("2. 学生の削除");
      System.out.println("3. 点数の更新");
      System.out.println("4. 平均点の計算");
      System.out.println("5. 学生一覧の表示");
      System.out.println("6. 終了");
      System.out.print("選択してください (1-6): ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // 改行を消費

      switch (choice) {
        case 1: // 学生の追加
          System.out.print("追加する学生の名前を入力してください: ");
          String newName = scanner.nextLine();
          System.out.print(newName + "さんの点数を入力してください: ");
          int newScore = scanner.nextInt();
          scanner.nextLine(); // 改行を消費

          names.add(newName);
          scores.add(newScore);
          System.out.println("学生が追加されました。");
          break;

        case 2: // 学生の削除
          System.out.print("削除する学生の名前を入力してください: ");
          String removeName = scanner.nextLine();
          if (names.contains(removeName)) {
            int index = names.indexOf(removeName);
            names.remove(index);
            scores.remove(index);
            System.out.println(removeName + "さんが削除されました。");
          } else {
            System.out.println("指定された名前が見つかりませんでした。");
          }
          break;

        case 3: // 点数の更新
          System.out.print("点数を更新する学生の名前を入力してください: ");
          String updateName = scanner.nextLine();
          if (names.contains(updateName)) {
            int index = names.indexOf(updateName);
            System.out.print(updateName + "さんの新しい点数を入力してください: ");
            int updatedScore = scanner.nextInt();
            scanner.nextLine(); // 改行を消費
            scores.set(index, updatedScore);
            System.out.println(updateName + "さんの点数が更新されました。");
          } else {
            System.out.println("指定された名前が見つかりませんでした。");
          }
          break;

        case 4: // 平均点の計算
          if (scores.isEmpty()) {
            System.out.println("学生が登録されていません。");
          } else {
            double average = scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            System.out.println("学生の平均点: " + average);
          }
          break;

        case 5: // 学生一覧の表示
          if (names.isEmpty()) {
            System.out.println("学生が登録されていません。");
          } else {
            System.out.println("\n学生一覧:");
            for (int i = 0; i < names.size(); i++) {
              System.out.println("名前: " + names.get(i) + ", 点数: " + scores.get(i));
            }
          }
          break;

        case 6: // 終了
          running = false;
          System.out.println("プログラムを終了します。");
          break;

        default: // 無効な入力
          System.out.println("無効な選択です。もう一度入力してください。");
          break;
      }
    }

    scanner.close();
  }
}
