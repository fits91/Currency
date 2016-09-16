package ua.org.fits.dao.interbank;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.org.fits.dao.SimpleDao;
import ua.org.fits.dao.rowmappers.InterBankRowMapper;
import ua.org.fits.rate.InterBank;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Override
    public void insertRateList(final List<InterBank> list) {

        String sql = "INSERT INTO interbank " +
                     "(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk) " +
                     "VALUES (?,?,?,?,?,?,?,?,?) ";


        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                InterBank ib = list.get(i);

                ps.setString(1, ib.getId());
                ps.setString(2, ib.getCurrency().name().toLowerCase());
                ps.setTimestamp(3,  Timestamp.valueOf(ib.getPointDate()));
                ps.setTimestamp(4,  Timestamp.valueOf(ib.getpDate()));
                ps.setBigDecimal(5, BigDecimal.valueOf(ib.getBid()));
                ps.setBigDecimal(6, BigDecimal.valueOf(ib.getAsk()));
                ps.setString(7, ib.getIsDeleted());
                ps.setBigDecimal(8, BigDecimal.valueOf(ib.getTrendBid()));
                ps.setBigDecimal(9, BigDecimal.valueOf(ib.getTrendAsk()));

            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        });
    }

    public void test() {
        System.out.println(getRateInfo(null));
    }
}
