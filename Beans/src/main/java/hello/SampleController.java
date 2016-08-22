package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.fits.dao.DaoInterBank;

/**
 * Created by developer on 21.06.2016.
 */
@Controller
@EnableScheduling
@EnableAutoConfiguration
public class SampleController {
//    @Autowired
//    @Qualifier("jdbcSecondary")
//    JdbcTemplate jdbcTemplate;

    @Autowired
    DaoInterBank daoInterBank;

@RequestMapping("/olx")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/sample")
    @ResponseBody
    String testdb() {

        return daoInterBank.getCur();
    }

//    @RequestMapping("/other")
//    @ResponseBody
//    String other() {
//        String sql = "SELECT curname FROM currency WHERE curid = ?";
//        String cur = jdbcTemplate.queryForObject(sql, String.class, "UAH");
//        return cur;
//    }


    @Scheduled(fixedDelay = 5000)
    public void printHello() {
        System.out.println("hello");
    }
}