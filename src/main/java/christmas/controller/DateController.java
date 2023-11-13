package christmas.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateController {
    public static boolean isWeekend(int date) {
        boolean result = false;
        LocalDate dateOfMonth = LocalDate.of(2023, 12, date);
        DayOfWeek dayOfWeek = dateOfMonth.getDayOfWeek();
        if (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.FRIDAY)) {
            result = true;
        }
        return result;
    }

    public static boolean isChristmas(int date) {
        boolean result = false;
        if (date == 25) {
            result = true;
        }
        return result;
    }

    public static boolean isSunday(int date) {
        boolean result = false;
        LocalDate dateOfMonth = LocalDate.of(2023, 12, date);
        DayOfWeek dayOfWeek = dateOfMonth.getDayOfWeek();
        if (dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            result = true;
        }
        return result;
    }
}
