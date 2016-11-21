package ua.org.fits.controllers.interbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.org.fits.dao.SimpleDao;
import ua.org.fits.rate.InterBank;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mb")

public class InterBankController {

    @Autowired
    @Qualifier("ibd")
    SimpleDao dao;

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }

    @RequestMapping("/test2")
    public List<InterBank> test2() {
        System.out.println(LocalDate.now());
//        return dao.getCurrencyList(LocalDate.now().minusDays(5));
        return dao.getCurrencyList();
    }

}
