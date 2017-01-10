package org.darugna.camel.csv;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.camel.Body;
import org.apache.camel.Header;
import org.darugna.camel.csv.dto.Company;

/**
 * This class uses <b>Body</b> and <b>Header</b> annotations to hint Camel
 */
public class MarketCapFilter {

    public List<Company> filter(@Body List<Company> companies,
            @Header("MINMARKETCAP") String minMarketCap) {
        
        BigDecimal filterValue = new BigDecimal(minMarketCap);
        
        return companies.stream()
                .filter(c -> c.getMarketCap().compareTo(filterValue) >= 0)
                .collect(Collectors.toList());
    }
}
