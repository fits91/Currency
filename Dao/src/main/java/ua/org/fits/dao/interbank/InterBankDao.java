package ua.org.fits.dao.interbank;


import org.springframework.stereotype.Component;
import ua.org.fits.dao.SimpleDao;
import ua.org.fits.rate.InterBank;

import java.sql.Timestamp;
import java.time.LocalDate;

@Component("ibd")
public class InterBankDao extends SimpleDao<InterBank>{

    @Override
    public LocalDate getMaxDate() {
        String sql = "SELECT MAX(dayDate) FROM interbank";

        LocalDate maxDate = jdbcTemplate.queryForObject(sql, Timestamp.class).toLocalDateTime().toLocalDate();

        maxDate = (maxDate == null? LocalDate.MAX : maxDate);

        return maxDate;
    }

}
