package com.example.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    // ==================== BASIC TESTS ====================

    // Test 1: Greet with correct name
    @Test
    public void testGreet() {
        String result = App.greet("DevOps Student");
        assertEquals("Hello, DevOps Student! DevOps Pipeline is Running Successfully.", result);
    }

    // Test 2: Greet with different name
    @Test
    public void testGreetWithDifferentName() {
        String result = App.greet("ABA");
        assertEquals("Hello, ABA! DevOps Pipeline is Running Successfully.", result);
    }

    // Test 3: Get version
    @Test
    public void testGetVersion() {
        String version = App.getVersion();
        assertEquals("v1.0", version);
    }

    // Test 4: Get pipeline status
    @Test
    public void testGetPipelineStatus() {
        String status = App.getPipelineStatus();
        assertEquals("Pipeline is Active and Running", status);
    }

    // ==================== CALCULATE AVERAGE TESTS ====================

    // Test 5: Average of normal marks
    @Test
    public void testCalculateAverage() {
        double[] marks = {85, 90, 78, 92, 88};
        double result = App.calculateAverage(marks);
        assertEquals(86.6, result, 0.01);
    }

    // Test 6: Average of equal marks
    @Test
    public void testCalculateAverageEqual() {
        double[] marks = {100, 100, 100};
        double result = App.calculateAverage(marks);
        assertEquals(100.0, result, 0.01);
    }

    // Test 7: Average of single mark
    @Test
    public void testCalculateAverageSingle() {
        double[] marks = {75};
        double result = App.calculateAverage(marks);
        assertEquals(75.0, result, 0.01);
    }

    // Test 8: Average of empty array
    @Test
    public void testCalculateAverageEmpty() {
        double[] marks = {};
        double result = App.calculateAverage(marks);
        assertEquals(0.0, result, 0.01);
    }

    // ==================== GET GRADE TESTS ====================

    // Test 9: Grade A (90 and above)
    @Test
    public void testGetGradeA() {
        String grade = App.getGrade(95);
        assertEquals("A", grade);
    }

    // Test 10: Grade A boundary (exactly 90)
    @Test
    public void testGetGradeABoundary() {
        String grade = App.getGrade(90);
        assertEquals("A", grade);
    }

    // Test 11: Grade B (80-89)
    @Test
    public void testGetGradeB() {
        String grade = App.getGrade(85);
        assertEquals("B", grade);
    }

    // Test 12: Grade C (70-79)
    @Test
    public void testGetGradeC() {
        String grade = App.getGrade(75);
        assertEquals("C", grade);
    }

    // Test 13: Grade D (60-69)
    @Test
    public void testGetGradeD() {
        String grade = App.getGrade(65);
        assertEquals("D", grade);
    }

    // Test 14: Grade F (below 60)
    @Test
    public void testGetGradeF() {
        String grade = App.getGrade(45);
        assertEquals("F", grade);
    }

    // ==================== GET RESULT TESTS ====================

    // Test 15: Result PASS (above 50)
    @Test
    public void testGetResultPass() {
        String result = App.getResult(75);
        assertEquals("PASS", result);
    }

    // Test 16: Result PASS (exactly 50)
    @Test
    public void testGetResultPassBoundary() {
        String result = App.getResult(50);
        assertEquals("PASS", result);
    }

    // Test 17: Result FAIL (below 50)
    @Test
    public void testGetResultFail() {
        String result = App.getResult(30);
        assertEquals("FAIL", result);
    }

    // ==================== IS PASSED TESTS ====================

    // Test 18: isPassed true
    @Test
    public void testIsPassedTrue() {
        assertTrue(App.isPassed(75));
    }

    // Test 19: isPassed false
    @Test
    public void testIsPassedFalse() {
        assertFalse(App.isPassed(30));
    }

    // Test 20: isPassed boundary (exactly 50)
    @Test
    public void testIsPassedBoundary() {
        assertTrue(App.isPassed(50));
    }

    // ==================== CALCULATE PERCENTAGE TESTS ====================

    // Test 21: Normal percentage
    @Test
    public void testCalculatePercentage() {
        double result = App.calculatePercentage(450, 500);
        assertEquals(90.0, result, 0.01);
    }

    // Test 22: Full marks percentage
    @Test
    public void testCalculatePercentageFullMarks() {
        double result = App.calculatePercentage(500, 500);
        assertEquals(100.0, result, 0.01);
    }

    // Test 23: Zero marks percentage
    @Test
    public void testCalculatePercentageZeroMarks() {
        double result = App.calculatePercentage(0, 500);
        assertEquals(0.0, result, 0.01);
    }

    // Test 24: Zero total marks (invalid)
    @Test
    public void testCalculatePercentageZeroTotal() {
        double result = App.calculatePercentage(100, 0);
        assertEquals(0.0, result, 0.01);
    }

    // ==================== GET TOP STUDENT TESTS ====================

    // Test 25: First student is top
    @Test
    public void testGetTopStudentFirst() {
        String result = App.getTopStudent("Aishwarya", 95, "Rahul", 88);
        assertEquals("Aishwarya", result);
    }

    // Test 26: Second student is top
    @Test
    public void testGetTopStudentSecond() {
        String result = App.getTopStudent("Aishwarya", 80, "Rahul", 92);
        assertEquals("Rahul", result);
    }

    // Test 27: Both students are equal
    @Test
    public void testGetTopStudentEqual() {
        String result = App.getTopStudent("Aishwarya", 90, "Rahul", 90);
        assertEquals("Both are equal", result);
    }
}
