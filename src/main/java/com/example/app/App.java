package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Library Management System Started.");
        System.out.println("=== Library Management System ===");

        System.out.println("Is 'Java Programming' available? : " + isBookAvailable("Java Programming"));
        System.out.println("Is '' available?                 : " + isBookAvailable(""));
        System.out.println("Fine for 5 days late             : Rs." + calculateFine(5));
        System.out.println("Fine for 0 days late             : Rs." + calculateFine(0));
        System.out.println("Category (3 books)               : " + getMemberCategory(3));
        System.out.println("Category (8 books)               : " + getMemberCategory(8));
        System.out.println("Category (15 books)              : " + getMemberCategory(15));
        System.out.println("Total books (120+80+50)          : " + getTotalBooks(120, 80, 50));
        System.out.println("Format Author                    : " + formatAuthorName("james", "gosling"));
        System.out.println("Can borrow (no dues)             : " + canBorrow(true, 0));
        System.out.println("Can borrow (has dues)            : " + canBorrow(true, 50));
        System.out.println("Discount for Senior              : " + getDiscount("Senior") + "%");
        System.out.println("Discount for Student             : " + getDiscount("Student") + "%");
        System.out.println("Discount for Regular             : " + getDiscount("Regular") + "%");
        System.out.println("Most Borrowed Book               : " + getMostBorrowedBook("Java", 45, "Python", 72));
        System.out.println("=================================");

        logger.info("Library Management System Completed Successfully.");
    }

    /**
     * Method 1: Check if a book is available.
     * Returns false if bookName is null or blank.
     */
    public static boolean isBookAvailable(String bookName) {
        if (StringUtils.isBlank(bookName)) {
            logger.warn("Book name is blank or null!");
            return false;
        }
        logger.info("Checking availability for: {}", bookName);
        return true;
    }

    /**
     * Method 2: Calculate overdue fine at Rs.5 per day.
     * Returns 0.0 for zero or negative days.
     */
    public static double calculateFine(int daysLate) {
        if (daysLate <= 0) {
            logger.info("No fine applicable.");
            return 0.0;
        }
        double fine = daysLate * 5.0;
        logger.info("Fine calculated: Rs.{} for {} days", fine, daysLate);
        return fine;
    }

    /**
     * Method 3: Determine member category by number of books borrowed.
     *   1–5  → Regular
     *   6–10 → Silver
     *   11+  → Gold
     */
    public static String getMemberCategory(int booksBorrowed) {
        if (booksBorrowed >= 11) {
            logger.info("Gold member: {} books", booksBorrowed);
            return "Gold";
        } else if (booksBorrowed >= 6) {
            logger.info("Silver member: {} books", booksBorrowed);
            return "Silver";
        } else {
            logger.info("Regular member: {} books", booksBorrowed);
            return "Regular";
        }
    }

    /**
     * Method 4: Sum total books across three sections.
     */
    public static int getTotalBooks(int fiction, int nonFiction, int reference) {
        int total = fiction + nonFiction + reference;
        logger.info("Total books in library: {}", total);
        return total;
    }

    /**
     * Method 5: Format author name as "Firstname Lastname".
     * Returns "Unknown Author" if either part is null or blank.
     */
    public static String formatAuthorName(String firstName, String lastName) {
        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
            logger.warn("Author name is invalid!");
            return "Unknown Author";
        }
        String formatted = StringUtils.capitalize(firstName) + " " + StringUtils.capitalize(lastName);
        logger.info("Formatted author name: {}", formatted);
        return formatted;
    }

    /**
     * Method 6: Check if a member can borrow books.
     * Must be a registered member with no pending fine.
     */
    public static boolean canBorrow(boolean isMember, double pendingFine) {
        if (!isMember) {
            logger.warn("Not a registered member!");
            return false;
        }
        if (pendingFine > 0) {
            logger.warn("Cannot borrow. Pending fine: Rs.{}", pendingFine);
            return false;
        }
        logger.info("Member is eligible to borrow books.");
        return true;
    }

    /**
     * Method 7: Return discount percentage by member type.
     *   Senior  → 20%
     *   Student → 15%
     *   default → 5%
     */
    public static int getDiscount(String memberType) {
        switch (memberType) {
            case "Senior":
                logger.info("Senior discount: 20%");
                return 20;
            case "Student":
                logger.info("Student discount: 15%");
                return 15;
            default:
                logger.info("Regular discount: 5%");
                return 5;
        }
    }

    /**
     * Method 8: Return the name of the most-borrowed book.
     * Returns "Both equally borrowed" when counts are equal.
     */
    public static String getMostBorrowedBook(String book1, int count1, String book2, int count2) {
        if (count1 > count2) {
            logger.info("{} is most borrowed with count: {}", book1, count1);
            return book1;
        } else if (count2 > count1) {
            logger.info("{} is most borrowed with count: {}", book2, count2);
            return book2;
        } else {
            logger.info("Both books equally borrowed: {}", count1);
            return "Both equally borrowed";
        }
    }
}
