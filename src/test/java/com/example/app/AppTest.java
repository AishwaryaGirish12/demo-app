package com.example.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    // ---------------------------------------------------------------
    // isBookAvailable
    // ---------------------------------------------------------------

    @Test
    public void testIsBookAvailable_ValidBook() {
        assertTrue(App.isBookAvailable("Java Programming"));
    }

    @Test
    public void testIsBookAvailable_EmptyName() {
        assertFalse(App.isBookAvailable(""));
    }

    @Test
    public void testIsBookAvailable_NullName() {
        assertFalse(App.isBookAvailable(null));
    }

    @Test
    public void testIsBookAvailable_BlankSpaces() {
        // Whitespace-only string should also be treated as unavailable
        assertFalse(App.isBookAvailable("   "));
    }

    // ---------------------------------------------------------------
    // calculateFine
    // ---------------------------------------------------------------

    @Test
    public void testCalculateFine_FiveDays() {
        assertEquals(25.0, App.calculateFine(5), 0.01);
    }

    @Test
    public void testCalculateFine_ZeroDays() {
        assertEquals(0.0, App.calculateFine(0), 0.01);
    }

    @Test
    public void testCalculateFine_NegativeDays() {
        assertEquals(0.0, App.calculateFine(-3), 0.01);
    }

    @Test
    public void testCalculateFine_TenDays() {
        assertEquals(50.0, App.calculateFine(10), 0.01);
    }

    @Test
    public void testCalculateFine_OneDay() {
        assertEquals(5.0, App.calculateFine(1), 0.01);
    }

    // ---------------------------------------------------------------
    // getMemberCategory
    // ---------------------------------------------------------------

    @Test
    public void testGetMemberCategory_Regular() {
        assertEquals("Regular", App.getMemberCategory(3));
    }

    @Test
    public void testGetMemberCategory_Silver() {
        assertEquals("Silver", App.getMemberCategory(8));
    }

    @Test
    public void testGetMemberCategory_Gold() {
        assertEquals("Gold", App.getMemberCategory(15));
    }

    @Test
    public void testGetMemberCategory_BoundaryRegularUpper() {
        // 5 is the last value that maps to Regular
        assertEquals("Regular", App.getMemberCategory(5));
    }

    @Test
    public void testGetMemberCategory_BoundarySilverLower() {
        // 6 is the first value that maps to Silver
        assertEquals("Silver", App.getMemberCategory(6));
    }

    @Test
    public void testGetMemberCategory_BoundarySilverUpper() {
        // 10 is the last value that maps to Silver
        assertEquals("Silver", App.getMemberCategory(10));
    }

    @Test
    public void testGetMemberCategory_BoundaryGoldLower() {
        // 11 is the first value that maps to Gold
        assertEquals("Gold", App.getMemberCategory(11));
    }

    // ---------------------------------------------------------------
    // getTotalBooks
    // ---------------------------------------------------------------

    @Test
    public void testGetTotalBooks_Normal() {
        assertEquals(250, App.getTotalBooks(120, 80, 50));
    }

    @Test
    public void testGetTotalBooks_Zero() {
        assertEquals(0, App.getTotalBooks(0, 0, 0));
    }

    @Test
    public void testGetTotalBooks_Large() {
        assertEquals(1000, App.getTotalBooks(500, 300, 200));
    }

    // ---------------------------------------------------------------
    // formatAuthorName
    // ---------------------------------------------------------------

    @Test
    public void testFormatAuthorName_Valid() {
        assertEquals("James Gosling", App.formatAuthorName("james", "gosling"));
    }

    @Test
    public void testFormatAuthorName_EmptyFirst() {
        assertEquals("Unknown Author", App.formatAuthorName("", "gosling"));
    }

    @Test
    public void testFormatAuthorName_EmptyLast() {
        assertEquals("Unknown Author", App.formatAuthorName("james", ""));
    }

    @Test
    public void testFormatAuthorName_NullFirst() {
        assertEquals("Unknown Author", App.formatAuthorName(null, "gosling"));
    }

    @Test
    public void testFormatAuthorName_NullLast() {
        assertEquals("Unknown Author", App.formatAuthorName("james", null));
    }

    @Test
    public void testFormatAuthorName_BothNull() {
        assertEquals("Unknown Author", App.formatAuthorName(null, null));
    }

    // ---------------------------------------------------------------
    // canBorrow
    // ---------------------------------------------------------------

    @Test
    public void testCanBorrow_Eligible() {
        assertTrue(App.canBorrow(true, 0));
    }

    @Test
    public void testCanBorrow_HasFine() {
        assertFalse(App.canBorrow(true, 50));
    }

    @Test
    public void testCanBorrow_NotMember() {
        assertFalse(App.canBorrow(false, 0));
    }

    @Test
    public void testCanBorrow_NotMemberAndHasFine() {
        assertFalse(App.canBorrow(false, 100));
    }

    // ---------------------------------------------------------------
    // getDiscount
    // ---------------------------------------------------------------

    @Test
    public void testGetDiscount_Senior() {
        assertEquals(20, App.getDiscount("Senior"));
    }

    @Test
    public void testGetDiscount_Student() {
        assertEquals(15, App.getDiscount("Student"));
    }

    @Test
    public void testGetDiscount_Regular() {
        assertEquals(5, App.getDiscount("Regular"));
    }

    @Test
    public void testGetDiscount_Unknown() {
        // Any unrecognised type falls through to the default (5%)
        assertEquals(5, App.getDiscount("VIP"));
    }

    // ---------------------------------------------------------------
    // getMostBorrowedBook
    // ---------------------------------------------------------------

    @Test
    public void testGetMostBorrowedBook_First() {
        assertEquals("Java", App.getMostBorrowedBook("Java", 80, "Python", 72));
    }

    @Test
    public void testGetMostBorrowedBook_Second() {
        assertEquals("Python", App.getMostBorrowedBook("Java", 45, "Python", 72));
    }

    @Test
    public void testGetMostBorrowedBook_Equal() {
        assertEquals("Both equally borrowed", App.getMostBorrowedBook("Java", 50, "Python", 50));
    }
}
