package org.darugna.camel.csv;

import java.util.List;
import java.util.stream.Collectors;
import org.darugna.camel.csv.dto.Company;
import org.darugna.camel.csv.dto.SimpleCompany;

/**
 * Converts a List&lt;Company> to a List&lt;SimpleCompany>
 * @author ale
 */
public class SimplifyProcessor {

    public List<SimpleCompany> process(List<Company> companies) {
        return companies.stream()
                .map(c -> {
                        SimpleCompany sc = new SimpleCompany();
                        sc.setName(c.getName());
                        sc.setSector(c.getSector());
                        sc.setSymbol(c.getSymbol());

                        return sc;
                    })
                .collect(Collectors.toList());
    }
}
