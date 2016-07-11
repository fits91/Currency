package ua.org.fits.rate;

import java.time.LocalDateTime;
import java.util.Currency;

/**
 * currency auction rate pojo
 */
public class CurrencyAuction {
    private Currency currency;
    private LocalDateTime date;
    private String bid;
    private String ask;
    private String bidCount;
    private String askCount;
    private String bidSum;
    private String askSum;
}
