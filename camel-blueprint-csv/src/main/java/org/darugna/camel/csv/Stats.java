package org.darugna.camel.csv;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.darugna.camel.csv.dto.Company;
import org.darugna.camel.csv.dto.Sector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stats {

    private final static Logger LOGGER = LoggerFactory.getLogger(Stats.class);
    
    public void printStats(List<Company> companies) {
        countBySector(companies);
        marketCaps(companies);
    }
    
    private void countBySector(List<Company> companies) {
        Map<Sector,Long> countBySector = companies
                .stream()
                .collect(Collectors.groupingBy(
                        c -> c.getSector(),
                        Collectors.counting()
                        ));
        LOGGER.info("There are {} sectors:", countBySector.keySet().size());
        countBySector.entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .forEach(
                    e -> LOGGER.info("  {} with {} companies", e.getKey(), e.getValue())
                );
        
    }

    private void marketCaps(List<Company> companies) {
        Optional<Company> greatestMarketCap = companies
                .stream()
                .max((c1, c2) -> c1.getMarketCap().compareTo(c2.getMarketCap()));
        
        Optional<Company> leastMarketCap = companies
                .stream()
                .max((c1, c2) -> c1.getMarketCap().compareTo(c2.getMarketCap()));
        
        LOGGER.info("Market caps range: [{} - {}]",
                leastMarketCap.get().getMarketCap(),
                greatestMarketCap.get().getMarketCap());
    }
    
}
