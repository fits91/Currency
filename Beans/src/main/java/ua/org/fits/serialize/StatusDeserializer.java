package ua.org.fits.serialize;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ua.org.fits.Constant;

import java.io.IOException;

public class StatusDeserializer extends JsonDeserializer<String>{
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String isDeleted = null;

        isDeleted = jsonParser.getText().equalsIgnoreCase(Constant.STATUS_DELETED)? Constant.YES : Constant.NO;

        return isDeleted;
    }
}
