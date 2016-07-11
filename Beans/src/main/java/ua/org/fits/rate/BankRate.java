package ua.org.fits.rate;

import java.time.LocalDateTime;
import java.util.Currency;

/**
 * bank's rate pojo
 */
public class BankRate {
    private Currency currency;
    private LocalDateTime date;
    private String bid;
    private String ask;
    private String trendBid;
    private String trendAsk;
}
