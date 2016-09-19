package org.darugna.camel.mqtt.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class Greeting {

    private String greeting;
    private LocalDateTime greetingDate;
    private Map<String,Integer> recipients;

    // keep away from marshalling
    private String toStringRepr;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public LocalDateTime getGreetingDate() {
        return greetingDate;
    }

    public void setGreetingDateTime(LocalDateTime greetingDate) {
        this.greetingDate = greetingDate;
    }

    public Map<String, Integer> getRecipients() {
        return recipients;
    }

    public void setRecipients(Map<String, Integer> recipients) {
        this.recipients = recipients;
    }
    
    public void addRecipient(String recipient, Integer numberOfGreets) {
        if (recipients == null) {
            recipients = new HashMap<>();
        }
        recipients.put(recipient, numberOfGreets);
    }
    
    @Override
    public String toString() {
        if (toStringRepr == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("On ").append(greetingDate)
                    .append(" I said '").append(greeting).append("' to:");
            recipients.keySet().forEach(k -> {
                sb.append(" ").
                        append(k).append(" ")
                        .append(recipients.get(k))
                        .append(" times.");
            });
            toStringRepr = sb.toString();
        }
        return toStringRepr;
    }

}
