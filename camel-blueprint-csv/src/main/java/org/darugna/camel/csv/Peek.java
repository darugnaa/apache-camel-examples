package org.darugna.camel.csv;

import java.util.Map;
import org.apache.camel.Exchange;

/**
 * 
 */
public class Peek {

    public void process(Exchange exchange) {
        Object body = exchange.getIn().getBody();
        Map<String,Object> h = exchange.getIn().getHeaders();
    }
}
