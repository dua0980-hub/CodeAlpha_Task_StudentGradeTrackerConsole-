package studentgradetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    // ANSI Escape Codes for Terminal Colors
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    
    // Background colors for special badges
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_RED = "\u001B[41m";
    public static final String TEXT_WHITE = "\u001B[37m";

    static class Student {
        private String name;
        private double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() { return name; }
        public double getGrade() { return grade; }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMainMenu();
            System.out.print(BOLD + "Select an option (1-4): " + RESET);
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent(students, scanner);
                    break;
                case "2":
                    displaySummaryReport(students);
                    break;
                case "3":
                    clearAllData(students);
                    break;
                case "4":
                    System.out.println("\n" + PURPLE + "Thank you for using Student Grade Tracker. Goodbye!" + RESET);
                    scanner.close();
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please choose 1, 2, 3, or 4." + RESET);
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n" + CYAN + "========================================" + RESET);
        System.out.println(BOLD + PURPLE + "       STUDENT GRADE TRACKER PRO       " + RESET);
        System.out.println(CYAN + "========================================" + RESET);
        System.out.println("1. Add Student & Grade");
        System.out.println("2. Generate Analytics Report (Avg, Max, Min)");
        System.out.println("3. Clear All Records");
        System.out.println("4. Exit Application");
        System.out.println(CYAN + "----------------------------------------" + RESET);
    }

    private static void addStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("\n" + YELLOW + "--- Add New Student Record ---" + RESET);
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println(RED + "Error: Name cannot be empty!" + RESET);
            return;
        }

        double grade = -1;
        while (true) {
            System.out.print("Enter grade (0 - 100): ");
            try {
                grade = Double.parseDouble(scanner.nextLine());
                if (grade >= 0 && grade <= 100) {
                    break;
                } else {
                    System.out.println(RED + "Error: Grade must be between 0 and 100." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Error: Please enter a valid number." + RESET);
            }
        }

        students.add(new Student(name, grade));
        System.out.println(GREEN + "Success: Student record added successfully!" + RESET);
    }

    private static void displaySummaryReport(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("\n" + RED + "No student records found. Add data first!" + RESET);
            return;
        }

        double total = 0;
        Student highest = students.get(0);
        Student lowest = students.get(0);

        System.out.println("\n" + GREEN + "========================================" + RESET);
        System.out.println(BOLD + GREEN + "           FINAL PERFORMANCE REPORT     " + RESET);
        System.out.println(GREEN + "========================================" + RESET);
        System.out.printf(BOLD + "%-20s | %-10s\n" + RESET, "Student Name", "Grade");
        System.out.println("----------------------------------------");

        for (Student s : students) {
            System.out.printf("%-20s | " + YELLOW + "%-10.2f\n" + RESET, s.getName(), s.getGrade());
            total += s.getGrade();

            if (s.getGrade() > highest.getGrade()) {
                highest = s;
            }
            if (s.getGrade() < lowest.getGrade()) {
                lowest = s;
            }
        }

        double average = total / students.size();

        System.out.println("----------------------------------------");
        System.out.printf(BOLD + "%-18s" + RESET + " : %d\n", "Total Enrolled", students.size());
        System.out.printf(BOLD + "%-18s" + RESET + " : " + CYAN + "%.2f\n" + RESET, "Class Average", average);
        System.out.println("----------------------------------------");
        
        System.out.println(BG_GREEN + TEXT_WHITE + BOLD + " HIGHEST SCORE " + RESET + 
                           " -> " + GREEN + BOLD + highest.getGrade() + RESET + " (" + highest.getName() + ")");
                           
        System.out.println(BG_RED + TEXT_WHITE + BOLD + " LOWEST SCORE  " + RESET + 
                           " -> " + RED + BOLD + lowest.getGrade() + RESET + " (" + lowest.getName() + ")");
        System.out.println(GREEN + "========================================" + RESET);
    }

    private static void clearAllData(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("\n" + RED + "Database is already empty." + RESET);
            return;
        }
        students.clear();
        System.out.println("\n" + RED + "All student records cleared completely!" + RESET);
    }
}
