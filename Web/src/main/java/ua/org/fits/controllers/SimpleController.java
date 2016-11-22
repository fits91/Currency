package ua.org.fits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.org.fits.dao.SimpleDao;

import java.time.LocalDate;
import java.util.List;

public abstract class SimpleController<T> {
    @Autowired
    SimpleDao<T> dao;

    @RequestMapping(method = RequestMethod.GET)
    List<T> getCurrencyList() {
        return dao.getCurrencyList();
    }
    @RequestMapping("/{date}")
    List<T> getCurrencyList(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return dao.getCurrencyList(date);
    }


}
