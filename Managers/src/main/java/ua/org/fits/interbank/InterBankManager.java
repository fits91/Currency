package ua.org.fits.interbank;


import org.springframework.stereotype.Component;
import ua.org.fits.Constant;
import ua.org.fits.SimpleManager;

import java.util.List;
@Component
public class InterBankManager implements SimpleManager<InterBankManager>{

    @Override
    public List<InterBankManager> getListFromMF() {
        System.out.println(getJsonStringFromMF());
        return null;
    }

    @Override
    public List<InterBankManager> getListFromDB() {
        return null;
    }

    @Override
    public void save(InterBankManager object) {

    }

    private String getJsonStringFromMF() {
        return Constant.interBankQuery;
    }


}
