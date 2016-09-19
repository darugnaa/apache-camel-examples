package org.darugna.camel.mqtt;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.stream.IntStream;
import org.darugna.camel.mqtt.dto.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingProducerBean {

    private final static Logger log = LoggerFactory.getLogger(GreetingProducerBean.class);
    
    private final Random random = new Random();
    
    // List of greetings. Original writings taken from Wikipedia.
    private final String[] GREETINGS = {
        "Hello!",
        "Good morning",
        "Ciao",
        "Salaam (سَلَام)",
        "Namaste (नमस्ते)",
        "Konnichiwa (今日は)"
    };
    
    private final String[] NAMES = {
        "Alessandro",
        "Pete",
        "Amit",
    };
    
    public Greeting produce() {
        Greeting g = new Greeting();
        g.setGreetingDateTime(LocalDateTime.now(ZoneOffset.UTC));
        g.setGreeting(GREETINGS[random.nextInt(GREETINGS.length)]);
        
        IntStream.range(1, 1 + random.nextInt(NAMES.length))
                .forEach(i -> {
                    g.addRecipient(NAMES[random.nextInt(NAMES.length)], i);
                });
        
        log.info("Produced greeting: {}", g);
        return g;
    }

}
