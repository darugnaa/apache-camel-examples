package org.darugna.camel.http;

import java.util.Arrays;
import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomTokenizer implements Processor {

    private final static Logger log = LoggerFactory.getLogger(CustomTokenizer.class);
    
    @Override
    public void process(Exchange exchange) throws Exception {
        String input = exchange.getIn().getBody(String.class);
        String[] values = input.split("\n");
        for (int i = 0; i < values.length; ++i) {
            // clean '\r' char on windows
            values[i] = values[i].trim();
        }
        // List<String> can be easily iterated
        List<String> valuesList = Arrays.asList(values);
        log.info("Loaded {} words: {}",
                valuesList.size(), valuesList);
        exchange.getIn().setBody(valuesList);
    }

}
