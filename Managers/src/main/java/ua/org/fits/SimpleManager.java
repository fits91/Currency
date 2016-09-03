package ua.org.fits;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public interface SimpleManager<T> {
    List<T> getListFromMF() throws IOException;
    List<T> getListFromDB();
    void save(T object);
}
