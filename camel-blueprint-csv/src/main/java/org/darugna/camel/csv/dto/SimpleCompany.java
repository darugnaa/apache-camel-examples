package org.darugna.camel.csv.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import org.apache.camel.dataformat.bindy.annotation.BindyConverter;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.darugna.camel.csv.formatters.SectionFormatter;

@XmlAccessorType(XmlAccessType.FIELD)
@CsvRecord(separator = ",")
public class SimpleCompany {
    
    @XmlElement
    @DataField(pos = 1)
    String symbol;
    
    @XmlAttribute
    @DataField(pos = 2)
    String name;
    
    @XmlAttribute
    @DataField(pos = 3)
    @BindyConverter(SectionFormatter.class)
    Sector sector;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    
}
