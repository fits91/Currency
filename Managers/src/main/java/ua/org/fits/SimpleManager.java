package ua.org.fits;


import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SimpleManager<T> {
    List<T> getListFromMF();
    List<T> getListFromDB();
    void save(T object);
}
