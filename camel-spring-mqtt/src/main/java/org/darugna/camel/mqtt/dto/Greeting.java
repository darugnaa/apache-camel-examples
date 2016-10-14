package org.darugna.camel.mqtt.dto;

import com.google.gson.annotations.Expose;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * This is an example class to be marshalled in JSON format.
 * One of the fields, toStringRepr, is excluded from marshalling.
 * 
 * @author alessandro.darugna@gmail.com
 */
public class Greeting {

    @Expose
    private String greeting;
    @Expose
    private LocalDateTime greetingDate;
    @Expose
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
