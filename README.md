# 🎓 学生管理プログラム

## 📖 プロジェクト概要
このプログラムは、学生の名前と各科目（数学・英語・理科・社会・国語）の点数を管理し、  
各教科ごとの平均点を算出するコンソールアプリケーションです。  
オブジェクト指向設計を採用し、`Student` クラスと `StudentManager` クラスに責務を分離しています。

---

## 🚀 機能一覧
- **学生の追加**（名前を入力し、各科目の点数を順番に入力 or スキップ可）
- **学生の削除**（指定した名前の学生を削除）
- **全科目の点数更新**（スキップも可）
- **教科ごとの平均点計算**（各科目の全学生の平均点を算出）
- **学生一覧の表示**（すべての学生の名前と点数を一覧表示）
- **プログラム終了**

---

## 🛠️ 実行方法
```sh
javac -d out src/org/example/*.java
java -cp out org.example.Main
```
または、IntelliJ IDEA などの IDE で `Main` クラスを実行。

---

## 🎮 操作方法
### **📌 メニュー画面**
```
学生管理プログラム:
1. 学生の追加
2. 学生の削除
3. 全科目の点数を更新
4. 教科ごとの平均点を計算
5. 学生一覧の表示
6. 終了
選択してください (1-6): 
```

### **📌 例**
#### **1️⃣ 学生の追加**
```
追加する学生の名前を入力してください: 田中
数学 の点数: 85
英語 の点数: 90
理科 の点数: -1  (スキップ)
社会 の点数: 75
国語 の点数: 88
```

#### **2️⃣ 学生一覧の表示**
```
学生一覧:
名前: 田中, 点数: 数学: 85, 英語: 90, 社会: 75, 国語: 88, 
```

#### **3️⃣ 教科ごとの平均点の計算**
```
各教科の平均点:
数学: 80.5
英語: 85.3
理科: 78.0
社会: 82.5
国語: 79.2
```

---

## 📌 クラス構成
```
org/example/
│── Main.java          // メインプログラム（ユーザー入力処理）
│── Student.java       // 学生クラス（名前・点数を管理）
│── StudentManager.java // 学生管理クラス（追加・削除・更新・一覧表示など）
```

---
