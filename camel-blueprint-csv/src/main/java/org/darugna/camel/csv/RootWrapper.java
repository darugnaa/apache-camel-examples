package org.darugna.camel.csv;

import java.util.List;
import org.darugna.camel.csv.dto.SimpleCompany;
import org.darugna.camel.csv.dto.SimpleCompanyRootElement;

public class RootWrapper {
    
    public SimpleCompanyRootElement wrap(List<SimpleCompany> simpleCompanies) {
        SimpleCompanyRootElement root = new SimpleCompanyRootElement();
        root.setSimpleCompanies(simpleCompanies);
        return root;
    }
}
