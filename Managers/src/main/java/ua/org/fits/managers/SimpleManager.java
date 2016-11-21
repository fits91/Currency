package ua.org.fits.managers;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
@Component
public interface SimpleManager<T> {
    List<T> getListFromMF(LocalDate date) throws IOException;
    void save(T object);
    void save(List<T> list) throws IOException;
}
