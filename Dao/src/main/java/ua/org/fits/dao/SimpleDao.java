package ua.org.fits.dao;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface SimpleDao<T> {
    List<T> getRateInfo(LocalDate date);
    LocalDate getMaxDate();

}
