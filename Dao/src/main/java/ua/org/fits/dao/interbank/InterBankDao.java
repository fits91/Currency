package ua.org.fits.dao.interbank;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.org.fits.dao.SimpleDao;
import ua.org.fits.dao.rowmappers.InterBankRowMapper;
import ua.org.fits.rate.InterBank;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component("ibd")
public class InterBankDao implements SimpleDao<InterBank>{
    @Autowired
    @Qualifier("testJDBC")
    JdbcTemplate jdbcTemplate;

//    public String getCur() {
//        String sql = "SELECT curname FROM currency WHERE curid = ?";
//        String cur = jdbcTemplate.queryForObject(sql, String.class, "UAH");
//        return cur;
//    }

    public void getCur() {
        String sql = "SELECT * FROM interbank";
//        String userName = jdbcTemplate.queryForObject(sql, String.class);
        List<Map<String, Object>> interbank = jdbcTemplate.queryForList(sql);
        System.out.println(interbank);
//        return null;
    }


    @Override
    public List<InterBank> getRateInfo(LocalDate date) {
        LocalDate maxDate = getMaxDate();

        LocalDate searchDate  = (date == null? maxDate : date);
        LocalDate searchDatePlusDay = searchDate.plusDays(1);

//        String sql = "SELECT * FROM interbank WHERE date >= ? AND <= ";
        String sql = "SELECT * FROM interbank WHERE date BETWEEN ? AND ? ";

        List<InterBank> interBanks = jdbcTemplate.query(sql, new java.sql.Date[]{Date.valueOf(searchDate), Date.valueOf(searchDatePlusDay)}, new InterBankRowMapper());

        return interBanks == null? Collections.emptyList() : interBanks;
    }

    @Override
    public List<InterBank> getRateInfo() {
        return null;
    }

    @Override
    public LocalDate getMaxDate() {
        String sql = "SELECT MAX(date) FROM interbank";

        LocalDate maxDate = jdbcTemplate.queryForObject(sql, Timestamp.class).toLocalDateTime().toLocalDate();

        maxDate = (maxDate == null? LocalDate.MAX : maxDate);

        return maxDate;
    }

    public void test() {
        System.out.println(getRateInfo(null));
    }
}
