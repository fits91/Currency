package ua.org.fits.serialize;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ua.org.fits.enums.Currency;

import java.io.IOException;

import static ua.org.fits.constant.CurrencyNBU.*;


public class CurrencyDeserializer extends JsonDeserializer<Currency> {
    @Override
    public Currency deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        Currency currency = null;

        switch (jsonParser.getText()) {
            case USD: currency = Currency.USD;
                      break;
            case EUR: currency = Currency.EUR;
                      break;
            case RUB: currency = Currency.RUB;
                      break;
        }
        return currency;

    }
}
