package ua.org.fits.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Scheduled(fixedDelay = 5000)
    public void getCur() {
        String sql = "SELECT * FROM interbank";
//        String userName = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(jdbcTemplate);
        List<Map<String, Object>> interbank = jdbcTemplate.queryForList(sql);
        System.out.println(interbank);
//        return null;
    }


}
