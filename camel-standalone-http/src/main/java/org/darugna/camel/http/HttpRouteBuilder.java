package org.darugna.camel.http;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class HttpRouteBuilder extends RouteBuilder {
    
    /**
     * Let's configure the Camel routing rules using Java code...
     */
    @Override
    public void configure() {
        from("file:data/input?noop=true")
            .process(new CustomTokenizer())
            .split(body(), new DefinitionAggregationStrategy())
                .setHeader("WORD", body())
                .to("direct:httprequest")
                .process(new HtmlProcessor())
                .end()
            .convertBodyTo(String.class)  // From StringBuilder to String
            .setHeader(Exchange.FILE_NAME, constant("definitions.txt"))
            .to("file:data/output?fileExist=Append")
            .log("Finished processing file ${header.CamelFileName}");
        
        
        from("direct:httprequest")
            .log("Requesting page '${body}'")
            .recipientList(simple("http://www.merriam-webster.com/dictionary/${body}"));
              
    }
}
