package com.samarat.airlinesdemoproject.util;

import com.samarat.airlinesdemoproject.config.exception.DateParseException;
import com.samarat.airlinesdemoproject.config.exception.DateValidationException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utility {
    public static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate getLocalDateFromString(String givenDate) {
        try {
            return LocalDate.parse(givenDate, pattern);
        } catch (Exception e) {
            throw new DateParseException("Date Parsing Error. Please give the correct date format('yyyy-MM-dd')");
        }
    }

    public static void checkAndValidateDateRange(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new DateValidationException("Start date cannot be after end date");
        }
    }


}
