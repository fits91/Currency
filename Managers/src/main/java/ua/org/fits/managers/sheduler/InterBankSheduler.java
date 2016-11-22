package ua.org.fits.managers.sheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InterBankSheduler {


    @Scheduled(fixedDelay = 60000)
    public void getDataFromMF() throws IOException {
//        LocalDate localDate = LocalDate.now();
//        localDate = localDate.minusDays(780);
//
//        System.out.println(localDate);
//        List<InterBank> interBankList = ibm.getListFromMF(null);
//        System.out.println(interBankList);
    }


    @Scheduled(fixedDelay = 5000)
    public void getDataFromMFConst() throws IOException {

//        List<InterBank> interBankList = ibm.getListFromMF(null);
//        System.out.println(interBankList);
    }
}
