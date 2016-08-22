package ua.org.fits.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.fits.dao.DaoInterBank;

/**
 * Created by developer on 04.08.2016.
 */
@Controller
public class Contr {
    @Autowired
    DaoInterBank daoInterBank;

    @RequestMapping("/testdb")
    @ResponseBody
    String testdb() {

        return daoInterBank.getCur();
    }
}
