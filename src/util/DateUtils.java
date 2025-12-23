package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate parseDate(String dateStr) {
        if (dateStr == null || dateStr.isBlank()) {
            throw new IllegalArgumentException("Date string cannot be null or empty");
        }

        try {
            return LocalDate.parse(dateStr, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException( "Invalid date format. Expected yyyy-MM-dd");
        }
    }

    public static boolean isDateInRange(
            LocalDate date,
            LocalDate start,
            LocalDate end
    ) {
        if (date == null || start == null || end == null) {
            return false;
        }

        return !date.isBefore(start) && !date.isAfter(end);
    }
}