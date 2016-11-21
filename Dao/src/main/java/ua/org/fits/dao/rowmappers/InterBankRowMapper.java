package ua.org.fits.dao.rowmappers;


import org.springframework.jdbc.core.RowMapper;
import ua.org.fits.enums.Currency;
import ua.org.fits.rate.InterBank;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterBankRowMapper implements RowMapper<InterBank>{
    @Override
    public InterBank mapRow(ResultSet resultSet, int i) throws SQLException {

        InterBank interBank = new InterBank();

        interBank.setId(resultSet.getString("id"));
        interBank.setCurrency(Currency.valueOf(resultSet.getString("curid").toUpperCase()));
        interBank.setpDate(resultSet.getTimestamp("dayDate").toLocalDateTime());
        interBank.setPointDate(resultSet.getTimestamp("pointDate").toLocalDateTime());
        interBank.setAsk(resultSet.getDouble("ask"));
        interBank.setBid(resultSet.getDouble("bid"));
        interBank.setTrendBid(resultSet.getDouble("trendBid"));
        interBank.setTrendAsk(resultSet.getDouble("trendAsk"));
        interBank.setIsDeleted(resultSet.getString("deleted"));

        return interBank;
    }

}
