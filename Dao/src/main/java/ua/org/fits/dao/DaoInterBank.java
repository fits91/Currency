package ua.org.fits.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DaoInterBank {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getCur() {
        String sql = "SELECT curname FROM currency WHERE curid = ?";
        String cur = jdbcTemplate.queryForObject(sql, String.class, "UAH");
        return cur;
    }
}
