package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        // Set date to 2024-06-01
        date.setYear(2025);
        date.setMonth(4);
        date.setDay(23);

        System.out.println("Initial date: " + date.getDay() + "-" + date.getMonth() + "-" + date.getYear());

        // Advance 14 days
        date.advanceDays(14);

        System.out.println("After advancing 10 days: " + date.getDay() + "-" + date.getMonth() + "-" + date.getYear());

        // Advance another 28 days
        date.advanceDays(28);

        System.out.println("After advancing 28 more days: " + date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
    }
}