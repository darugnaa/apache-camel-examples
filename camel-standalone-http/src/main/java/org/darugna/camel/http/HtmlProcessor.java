package org.darugna.camel.http;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlProcessor implements Processor {

    private final static Logger log = LoggerFactory.getLogger(HtmlProcessor.class);
    
    @Override
    public void process(Exchange exchange) throws Exception {
        String htmlSource = exchange.getIn().getBody(String.class);
        Document page = Jsoup.parse(htmlSource);
        Elements definitions = page.getElementsByClass("definition-inner-item with-sense");
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append(exchange.getIn().getHeader("WORD"))
                .append("\n");
        
        for (Element p : definitions) {
            String definitionText = p.text();
            int firstColonIndex = definitionText.indexOf(":");
            definitionText = definitionText.substring(firstColonIndex + 1).trim();
            sb.append(" - ").append(definitionText).append("\n");
        }
        exchange.getIn().setBody(sb.toString());
        
        log.info("Parsed {} definitions for word '{}'",
                definitions.size(), exchange.getIn().getHeader("WORD"));
    }
}
