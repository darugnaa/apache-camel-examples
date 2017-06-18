package org.darugna.camel.csv.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleCompanyRootElement {

    @XmlElement(name = "company")
    List<SimpleCompany> simpleCompanies;

    public List<SimpleCompany> getSimpleCompanies() {
        return simpleCompanies;
    }

    public void setSimpleCompanies(List<SimpleCompany> simpleCompanies) {
        this.simpleCompanies = simpleCompanies;
    }
    
}
