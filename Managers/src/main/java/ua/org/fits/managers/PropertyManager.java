package ua.org.fits.managers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

@Component
@Scope("prototype")
public class PropertyManager {

    private static String PROPERTY_LOCATION = "Managers/src/main/resources/config.properties";

    protected Properties prop = new Properties();

    public String getMBURL() throws IOException {

        Optional<String> url;

        try(InputStream input = new FileInputStream(PROPERTY_LOCATION)) {
            prop.load(input);
            url = Optional.of(prop.getProperty("mb"));
        }

        return url.get();
    }

    public String getToken() throws IOException {

        Optional<String> token;

        try(InputStream input = new FileInputStream(PROPERTY_LOCATION)) {
            prop.load(input);
            token = Optional.of(prop.getProperty("token"));
        }

        return token.get();
    }

    public static void main(String[] args) {
        try {
            System.out.println(new PropertyManager().getToken());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
