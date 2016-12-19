package org.darugna.camel.csv.formatters;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.dataformat.bindy.Format;
import org.darugna.camel.csv.dto.Sector;

public class SectionFormatter implements Format<Sector> {

    private final Map<String, Sector> stringToSector;
    private final Map<Sector, String> sectorToString;
    
    public SectionFormatter() {
        stringToSector = new HashMap<>();
        sectorToString = new HashMap<>();
        addMapping("n/a", Sector.NotAvailable);
        addMapping("Technology", Sector.Technology);
        addMapping("Health Care", Sector.HealthCare);
        addMapping("Consumer Services", Sector.ConsumerServices);
        addMapping("Capital Goods", Sector.CapitalGoods);
        addMapping("Consumer Durables", Sector.ConsumerDurables);
        addMapping("Finance", Sector.Finance);
        addMapping("Consumer Non-Durables", Sector.ConsumerNonDurables);
        addMapping("Public Utilities", Sector.PublicUtilities);
        addMapping("Basic Industries", Sector.BasicIndustries);
        addMapping("Energy", Sector.Energy);
        addMapping("Miscellaneous", Sector.Miscellaneous);
        addMapping("Transportation", Sector.Transportation);
    }
    
    @Override
    public String format(Sector t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sector parse(String string) throws Exception {
        Sector sector = stringToSector.get(string);
        if (sector == null) {
            throw new IllegalArgumentException("Cannot parse Sector '" + string + "'");
        }
        return sector;
    }
    
    private void addMapping(String name, Sector sector) {
        stringToSector.put(name, sector);
        sectorToString.put(sector, name);
    }

}
