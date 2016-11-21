package ua.org.fits.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public abstract class SimpleDao<T> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    protected GetCurrencyListBehavior<T> currencyListBehavior;

    public List<T> getCurrencyList() {
        LocalDate maxDate = getMaxDate();
        return currencyListBehavior.getCurrencyList(maxDate);
    }
    public List<T> getCurrencyList(LocalDate date) {
        return currencyListBehavior.getCurrencyList(date);
    }

    public abstract LocalDate getMaxDate();

}
