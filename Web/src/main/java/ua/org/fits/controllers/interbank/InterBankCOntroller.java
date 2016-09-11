package ua.org.fits.controllers.interbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.org.fits.dao.SimpleDao;
import ua.org.fits.rate.InterBank;

import java.util.List;

@RestController
@RequestMapping("/mb")

public class InterBankController {

    @Autowired
    @Qualifier("ibd")
    SimpleDao simpleDao;

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }

    @RequestMapping("/test2")
    public List<InterBank> test2() {
        return simpleDao.getRateInfo(null);
    }
}
