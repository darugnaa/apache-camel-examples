package org.darugna.camel.raas.consumer;

import org.darugna.camel.raas.CamelRaas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This bean as a reference to CamelRaas interface. It is injected in this context
 * as an OSGi service. Each method call to this interface will invoke a Camel
 * route.
 * 
 * @author Alessandro Da Rugna (alessandro.darugna@gmail.com)
 */
public class ConsumerBeanThatUsesService {

    private final static Logger log = LoggerFactory.getLogger(ConsumerBeanThatUsesService.class);
    
    private CamelRaas camelRaas;

    public void setCamelRaas(CamelRaas camelRaas) {
        this.camelRaas = camelRaas;
    }
    
    public Integer useCamelRouteInsideServiceOneParameter() {
        return camelRaas.methodOne("Hello, I am using a standard Java Interface");
    }
    
    public Integer useCamelRouteInsideServiceTwoParameters() {
        return camelRaas.methodTwo("Java interface with two parameters...",
                "will this work?");
    }

}
