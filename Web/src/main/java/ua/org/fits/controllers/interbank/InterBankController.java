package ua.org.fits.controllers.interbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.org.fits.formatter.LocalDateTimeFormatter;
import ua.org.fits.managers.SimpleManager;
import ua.org.fits.rate.InterBank;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mb")

public class InterBankController {

    @Autowired
    @Qualifier("ibm")
    SimpleManager ibm;

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }

    @RequestMapping(value = "{date}")
    public List<InterBank> getInterBanksDate(@PathVariable String date) {
        LocalDate ld = LocalDate.parse(date, LocalDateTimeFormatter.get_YYYY_MM_DD_pattern());
        System.out.println(ld);
        return ibm.getListFromDB(ld);
    }

    @RequestMapping(value = "")
    public List<InterBank> getInterBanks() {
        return ibm.getListFromDB(null);
    }
}
