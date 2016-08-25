package ua.org.fits.interbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.org.fits.SimpleManager;
import ua.org.fits.SimpleService;

/**
 * Created by developer on 23.08.2016.
 */
@Component
public class InterBankService implements SimpleService {

    @Autowired
    SimpleManager<InterBankManager> manager;

    @Override
    public void parseDataFromMF() {
        System.out.println("hello");
        manager.getListFromMF();
    }
}
