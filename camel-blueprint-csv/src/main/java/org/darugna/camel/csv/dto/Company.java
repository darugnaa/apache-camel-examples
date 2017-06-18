package org.darugna.camel.csv.dto;

import java.math.BigDecimal;
import org.apache.camel.dataformat.bindy.annotation.BindyConverter;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.darugna.camel.csv.formatters.BigDecimalFormatter;
import org.darugna.camel.csv.formatters.SectionFormatter;

@CsvRecord(separator = ",", skipFirstLine = true)
public class Company {
    
    @DataField(pos = 1)
    String symbol;
    
    @DataField(pos = 2)
    String name;
    
    @DataField(pos = 3)
    @BindyConverter(BigDecimalFormatter.class)
    BigDecimal lastSale;
    
    @DataField(pos = 4)
    @BindyConverter(BigDecimalFormatter.class)
    BigDecimal marketCap;
    
    @DataField(pos = 5)
    String tso;
    
    @DataField(pos = 6)
    String ipoYear;
    
    @DataField(pos = 7)
    @BindyConverter(SectionFormatter.class)
    Sector sector;
    
    @DataField(pos = 8)
    String industry;
    
    @DataField(pos = 9)
    String url;

    @DataField(pos = 10)
    String empty;
    
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

    public BigDecimal getLastSale() {
        return lastSale;
    }

    public void setLastSale(BigDecimal lastSale) {
        this.lastSale = lastSale;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public String getTso() {
        return tso;
    }

    public void setTso(String tso) {
        this.tso = tso;
    }

    public String getIpoYear() {
        return ipoYear;
    }

    public void setIpoYear(String ipoYear) {
        this.ipoYear = ipoYear;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
}
