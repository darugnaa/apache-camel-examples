package org.darugna.camel.raas;

import org.apache.camel.Body;
import org.apache.camel.Header;

/**
 * This is the published service interface.
 * 
 * Camel will bind parameters using binding information from the annotations. 
 * 
 * @author Alessandro Da Rugna (alessandro.darugna@gmail.com)
 */
public interface CamelRaas {

    Integer methodOne(@Body String arg0);
    
    Integer methodTwo(@Header("ARG0")String arg0,
            @Header("ARG1") String arg1);
    
}
