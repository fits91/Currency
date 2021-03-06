package ua.org.fits.managers.interbank;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ua.org.fits.Constant;
import ua.org.fits.dao.SimpleDao;
import ua.org.fits.managers.PropertyManager;
import ua.org.fits.rate.InterBank;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component("ibm")
public class InterBankManager {

    @Autowired
    PropertyManager pm;

    @Autowired
    @Qualifier("ibd")
    SimpleDao ibd;

    public List<InterBank> getListFromMF(LocalDate date) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<InterBank> interBanks = null;

//        interBanks = mapper.readValue(getJSONFromMF(date), new TypeReference<List<InterBank>>(){});
        interBanks = mapper.readValue(getJsonStringFromMF(), new TypeReference<List<InterBank>>(){});

        return interBanks == null? Collections.emptyList() : interBanks;
    }


    private String getJSONFromMF(LocalDate date) throws IOException {
        PropertyManager propertyManager = new PropertyManager();

        URL mbURL = new URL(generateURL(date));

        HttpURLConnection conn = (HttpURLConnection) mbURL.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = conn.getResponseCode();

        if(responseCode != HttpStatus.OK.value()) throw new HTTPException(responseCode);

        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {

            String inputLine;

            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            return response.toString();

        }

    }


    private String generateURL(LocalDate date) throws IOException {
        Optional<String> url;

        if(date == null) {
            url = Optional.ofNullable(pm.getMBURL() + pm.getToken());
        }
        else {
            url = Optional.ofNullable(pm.getMBURL() + pm.getToken() + "/" + date);
        }

        return url.get();
    }


//    @Override
//    public List<InterBank> getListFromDB(LocalDate date) {
//        return ibd.getRateInfo(date);
//    }


    public void save(InterBank object) {

    }

    public void save(List<InterBank> list) throws IOException {

}


    private String getJsonStringFromMF() {
        return Constant.interBankQuery;
    }

    public static void main(String[] args) {
        InterBankManager manager = new InterBankManager();
        try {
            manager.getJSONFromMF(LocalDate.now());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
