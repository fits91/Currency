package ua.org.fits.interbank;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ua.org.fits.Constant;
import ua.org.fits.SimpleManager;
import ua.org.fits.rate.InterBank;

import java.io.IOException;
import java.util.List;
@Component
public class InterBankManager implements SimpleManager<InterBankManager>{

    @Override
    public List<InterBankManager> getListFromMF()  {
        ObjectMapper mapper = new ObjectMapper();
        List<InterBank> interBanks = null;
        try {
            interBanks = mapper.readValue(getJsonStringFromMF(), new TypeReference<List<InterBank>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(interBanks.size());

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

    public static void main(String[] args) {
        SimpleManager<InterBankManager> manager = new InterBankManager();
        try {
            manager.getListFromMF();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
