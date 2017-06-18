package org.darugna.camel.virtualtopic;

import java.util.concurrent.atomic.AtomicLong;


public class MessageGenerator {

    private final AtomicLong messageId = new AtomicLong();

    public String generate() {
        return "Message <" + messageId.incrementAndGet() + ">";
    }
}
