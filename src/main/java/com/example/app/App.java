package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String name = "DevOps Student";

        if (StringUtils.isNotBlank(name)) {
            String message = greet(name);
            logger.info(message);
            System.out.println(message);
        } else {
            logger.error("Name is blank or empty!");
        }

        System.out.println("App Version      : " + getVersion());
        System.out.println("Pipeline Status  : " + getPipelineStatus());

        // Student Grade System Examples
        double[] marks = {85, 90, 78, 92, 88};
        double avg = calculateAverage(marks);
        System.out.println("Average Marks    : " + avg);
        System.out.println("Grade            : " + getGrade(avg));
        System.out.println("Result           : " + getResult(avg));
        System.out.println("Is Pass(75)      : " + isPassed(75));
        System.out.println("Is Pass(30)      : " + isPassed(30));
        System.out.println("Percentage(450,500): " + calculatePercentage(450, 500) + "%");
        System.out.println("Top Student      : " + getTopStudent("Aishwarya", 95, "Rahul", 88));
    }

    // Method 1: Greet user
    public static String greet(String name) {
        return "Hello, " + name + "! DevOps Pipeline is Running Successfully.";
    }

    // Method 2: Get app version
    public static String getVersion() {
        return "v1.0";
    }

    // Method 3: Get pipeline status
    public static String getPipelineStatus() {
        return "Pipeline is Active and Running";
    }

    // Method 4: Calculate average of marks array
    public static double calculateAverage(double[] marks) {
        if (marks == null || marks.length == 0) {
            logger.warn("Marks array is empty or null!");
            return 0.0;
        }
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        double average = sum / marks.length;
        logger.info("Calculated average: " + average);
        return Math.round(average * 100.0) / 100.0;
    }

    // Method 5: Get grade based on marks
    // A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60
    public static String getGrade(double marks) {
        if (marks >= 90) {
            logger.info("Grade A awarded for marks: " + marks);
            return "A";
        } else if (marks >= 80) {
            logger.info("Grade B awarded for marks: " + marks);
            return "B";
        } else if (marks >= 70) {
            logger.info("Grade C awarded for marks: " + marks);
            return "C";
        } else if (marks >= 60) {
            logger.info("Grade D awarded for marks: " + marks);
            return "D";
        } else {
            logger.warn("Grade F awarded for marks: " + marks);
            return "F";
        }
    }

    // Method 6: Get Pass or Fail result
    // Pass if marks >= 50, Fail if below 50
    public static String getResult(double marks) {
        if (marks >= 50) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    // Method 7: Check if student passed
    public static boolean isPassed(double marks) {
        return marks >= 50;
    }

    // Method 8: Calculate percentage
    public static double calculatePercentage(double marksObtained, double totalMarks) {
        if (totalMarks == 0) {
            logger.error("Total marks cannot be zero!");
            return 0.0;
        }
        double percentage = (marksObtained / totalMarks) * 100;
        return Math.round(percentage * 100.0) / 100.0;
    }

    // Method 9: Get top student between two students
    public static String getTopStudent(String name1, double marks1, String name2, double marks2) {
        if (marks1 > marks2) {
            logger.info(name1 + " is the top student with marks: " + marks1);
            return name1;
        } else if (marks2 > marks1) {
            logger.info(name2 + " is the top student with marks: " + marks2);
            return name2;
        } else {
            logger.info("Both students have equal marks: " + marks1);
            return "Both are equal";
        }
    }
}
