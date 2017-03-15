package org.darugna.camel.raas.impl;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the service logic. After processing, the body of the Exchange must
 * be an instance of Integer or something that can be converted to. This is required
 * to match the signature of the implemented interface.
 * 
 * @author Alessandro Da Rugna (alessandro.darugna@gmail.com)
 */
public class ServiceProcessor implements Processor {

    private final static Logger log = LoggerFactory.getLogger(ServiceProcessor.class);
    
    @Override
    public void process(Exchange exchange) throws Exception {
        Integer value;
        
        String body = exchange.getIn().getBody(String.class);
        if (body != null) {
            // method call with one argument
            log.info("Route invoked from 'methodOne'");
            value = body.length();
        } else {
            // method call with two arguments
            log.info("Route invoked from 'methodTwo'");
            String arg0 = exchange.getIn().getHeader("ARG0", String.class);
            String arg1 = exchange.getIn().getHeader("ARG1", String.class);
            value = arg0.length() + arg1.length();
        }
        
        exchange.getIn().setBody(value);
    }


}
