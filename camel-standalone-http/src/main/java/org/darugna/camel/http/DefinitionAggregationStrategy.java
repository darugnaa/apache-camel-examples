package org.darugna.camel.http;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefinitionAggregationStrategy implements AggregationStrategy {

    private final static Logger log = LoggerFactory.getLogger(DefinitionAggregationStrategy.class);
            
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            // First time this method is called there is no 'oldExchange'
            StringBuilder sb = new StringBuilder();
            sb.append(newExchange.getIn().getBody());
            newExchange.getIn().setBody(sb);
            return newExchange;
        }

        // We accumulate all the definitions in the 'oldExchange' StringBuilder
        StringBuilder accumulator = oldExchange.getIn().getBody(StringBuilder.class);
        accumulator.append(newExchange.getIn().getBody());
        
        return oldExchange;
    }

}
