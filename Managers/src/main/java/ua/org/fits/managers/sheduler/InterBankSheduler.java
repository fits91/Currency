package ua.org.fits.managers.sheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.org.fits.managers.SimpleManager;

import java.io.IOException;
import java.time.LocalDate;

@Component
public class InterBankSheduler {

    @Autowired
    @Qualifier("ibm")
    SimpleManager ibm;

    @Scheduled(fixedDelay = 60000)
    public void getDataFromMF() throws IOException {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(780);

        System.out.println(localDate);

//        List<InterBank> interBankList = ibm.getListFromMF(null);
//        System.out.println(interBankList);
    }


    @Scheduled(fixedDelay = 5000)
    public void getDataFromMFConst() throws IOException {
        System.out.println(ibm.getListFromMF(null));

//        List<InterBank> interBankList = ibm.getListFromMF(null);
//        System.out.println(interBankList);
    }
}
