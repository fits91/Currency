package ua.org.fits.controllers.interbank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.org.fits.controllers.SimpleController;
import ua.org.fits.rate.InterBank;

@RestController
@RequestMapping("/mb")
public class InterBankController extends SimpleController<InterBank>{

}
