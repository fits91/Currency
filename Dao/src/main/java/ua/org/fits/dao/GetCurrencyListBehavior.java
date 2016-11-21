package ua.org.fits.dao;

import java.time.LocalDate;
import java.util.List;

public interface GetCurrencyListBehavior<T> {
    List<T> getCurrencyList(LocalDate date);
}
