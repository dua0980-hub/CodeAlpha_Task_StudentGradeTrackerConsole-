# 🎓 STUDENT GRADE TRACKER PRO

![Java](https://shields.io)
![Terminal](https://shields.io)
![NetBeans](https://shields.io)

An interactive, terminal-based **Academic Performance Tracker** engineered in Java. The application delivers robust statistical calculations, safe input exception handling, and an immersive color-coded console workspace driven by programmatic ANSI Escape Sequence rendering engines.

---

## 🎨 Immersive Console Interface Features

- **Semantic Color Coding:** Uses clean ANSI terminal escapes to flash errors in Crimson Red, success prompts in Emerald Green, metrics dashboards in Cyan, and warnings in Alert Yellow.
- **Embedded Performance Badges:** Features custom high-contrast background label badges (`BG_GREEN` and `BG_RED`) to instantly anchor analytical focus on the highest and lowest classroom scores.
- **Structured Matrix Formatting:** Automatically builds perfectly spaced summary reports using customized layout format sequences (`%-20s | %-10.2f`).

---

## ⚡ Core Functionalities & Built-In Safeguards

- **🛡️ Strict Type-Safety Safeguards:** Encapsulates parsing boundaries inside isolated `try-catch` structures to block application crashes if string configurations or invalid letters are typed into data numerical prompts.
- **📊 Range Boundary Verification:** Validates student grades continuously against legal mathematical structures, restricting acceptable inputs strictly between `0.00` and `100.00`.
- **📈 On-the-Fly Statistical Aggregations:** Calculates arithmetic class averages, locates maximum score bounds, and isolates minimal data properties over a single-pass dataset scanning array.
- **🧹 Memory Flushing Control:** Employs explicit structural collection cleanups (`students.clear()`) to dynamically drop cached system memory footprints instantly.

---

## 📂 Project Structure Directory View

The source code follows clean class structure definitions to optimize data tracking encapsulation properties:

```text
StudentGradeTracker/
│
├── src/studentgradetracker/
│   └── StudentGradeTracker.java   # Main Controller, Interface Layout, & Execution Pipeline
│
├── build.xml                      # Ant Automated Tool Framework Configurations
├── manifest.mf                    # Execution Assembly System Flags
└── nbproject/                      # Native NetBeans Metadata Cache Files
```

---

## ⚙️ Quick Installation & Compilation Guide

### 1. Build and Run via Native OS Command Line Terminal
Navigate directly into your workspace project src folder index location inside your terminal panel window and run:

```bash
# Compile the target system framework definitions
javac studentgradetracker/StudentGradeTracker.java

# Deploy and run the interactive CLI application instance
java studentgradetracker.StudentGradeTracker
```

### 2. Assembly Setup Inside Apache NetBeans IDE
1. Open Apache NetBeans and choose **File** -> **Open Project**.
2. Select your main `StudentGradeTracker` parent architecture folder node directory directory.
3. Locate the file named `StudentGradeTracker.java` underneath your source compilation packages.
4. Press **Shift + F6** (or Right-Click -> **Run File**) to launch the terminal shell loop simulation.

---

## 🖥️ Workspace Demonstration Sample View

```text
========================================
       STUDENT GRADE TRACKER PRO       
========================================
1. Add Student & Grade
2. Generate Analytics Report (Avg, Max, Min)
3. Clear All Records
4. Exit Application
----------------------------------------
Select an option (1-4): 2

========================================
           FINAL PERFORMANCE REPORT     
========================================
Student Name         | Grade     
----------------------------------------
Dua                  | 95.50
Ali                  | 72.00
----------------------------------------
Total Enrolled     : 2
Class Average      : 83.75
----------------------------------------
 HIGHEST SCORE  -> 95.50 (Dua)
 LOWEST SCORE   -> 72.00 (Ali)
========================================
```

