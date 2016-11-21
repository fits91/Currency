package ua.org.fits.dao.interbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.org.fits.dao.GetCurrencyListBehavior;
import ua.org.fits.dao.rowmappers.InterBankRowMapper;
import ua.org.fits.rate.InterBank;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Component("IBCurrencyList")
public class GetIBankCurrencyList implements GetCurrencyListBehavior<InterBank>{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<InterBank> getCurrencyList(LocalDate date) {
        return jdbcTemplate.query("SELECT * FROM interbank where convert(dayDate, date) = ?", new Date[]{Date.valueOf(date)}, new InterBankRowMapper());
    }
}
