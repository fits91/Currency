package ua.org.fits.dao.interbank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by developer on 12.09.2016.
 */
@RestController
public class Cntrl {
    @RequestMapping("/")
    String tst(){return "test";}
}
