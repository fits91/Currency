package hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by developer on 21.06.2016.
 */
@Controller
@EnableScheduling
@EnableAutoConfiguration
public class SampleController2 {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
@RequestMapping("/drive")
    @ResponseBody
    String home() {
        return "Hello World222222!";
    }

//    @RequestMapping("/testdb")
//    @ResponseBody
//    String testdb() {
//        String sql = "SELECT curname FROM currency WHERE curid = ?";
//        String cur = jdbcTemplate.queryForObject(sql, String.class, "UAH");
//        return cur;
//    }


    @Scheduled(fixedDelay = 5000)
    public void printHello() {
        System.out.println("hello");
    }
}