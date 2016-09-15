package ua.org.fits.formatter;


import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter {


    public static DateTimeFormatter get_YYYY_MM_DD_HH_MM_SS_pattern() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public static DateTimeFormatter get_YYYY_MM_DD_pattern() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }
}
