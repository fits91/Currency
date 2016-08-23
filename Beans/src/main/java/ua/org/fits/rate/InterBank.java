package ua.org.fits.rate;

import java.time.LocalDateTime;
import java.util.Currency;

/**
 * interbank rate pojo
 */
public class InterBank {

    private long id;
    private LocalDateTime pointDate;
    private LocalDateTime pDate;
    private Double bid;
    private Double ask;
    private Currency currency;
    private String isDeleted;


}
