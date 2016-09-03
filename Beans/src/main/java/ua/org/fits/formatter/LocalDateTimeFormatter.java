package ua.org.fits.formatter;


import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter {

    /**
     * parse string of format "yyyy-MM-dd HH:mm:ss" to LocalDateTime
     * @return
     */
    public static DateTimeFormatter get_YYYY_MMDD_HH_MM_SS_pattern() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
}
