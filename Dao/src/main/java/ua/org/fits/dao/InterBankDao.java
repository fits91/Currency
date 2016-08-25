package ua.org.fits.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class InterBankDao {
    @Autowired
    @Qualifier("testJDBC")
    JdbcTemplate jdbcTemplate;

//    public String getCur() {
//        String sql = "SELECT curname FROM currency WHERE curid = ?";
//        String cur = jdbcTemplate.queryForObject(sql, String.class, "UAH");
//        return cur;
//    }

    public String getCur() {
        String sql = "SELECT * FROM currency";
//        String userName = jdbcTemplate.queryForObject(sql, String.class);
        List<Map<String, Object>> userName = jdbcTemplate.queryForList(sql);
        System.out.println(userName);
        return "userName";
    }
}
