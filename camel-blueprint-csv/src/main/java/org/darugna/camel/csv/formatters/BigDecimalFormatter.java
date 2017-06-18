package org.darugna.camel.csv.formatters;

import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.camel.dataformat.bindy.Format;

public class BigDecimalFormatter implements Format<BigDecimal> {

    private final MathContext mathContext = new MathContext(4);
    
    @Override
    public String format(BigDecimal object) throws Exception {
        return object.toPlainString();
    }

    @Override
    public BigDecimal parse(String string) throws Exception {
        // handle special case: value not available
        if ("n/a".equals(string)) {
            return null;
        }
        
        return new BigDecimal(string, mathContext);
    }

}
