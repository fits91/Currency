package ua.org.fits.managers.sheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.org.fits.managers.interbank.InterBankManager;

import java.io.IOException;
import java.time.LocalDate;

@Component
public class InterBankSheduler {

    @Autowired
    InterBankManager ibm;

    @Scheduled(fixedDelay = 60000)
    public void getDataFromMF() throws IOException {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(780);

        System.out.println(localDate);

//        List<InterBank> interBankList = ibm.getListFromMF(null);
//        System.out.println(interBankList);
    }
}
