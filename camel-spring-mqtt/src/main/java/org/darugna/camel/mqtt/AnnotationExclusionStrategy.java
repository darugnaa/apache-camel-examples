package org.darugna.camel.mqtt;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.lang.annotation.Annotation;
import org.darugna.camel.mqtt.dto.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AnnotationExclusionStrategy implements ExclusionStrategy {

    private final static Logger log = LoggerFactory.getLogger(AnnotationExclusionStrategy.class);

    @Override
    public boolean shouldSkipField(FieldAttributes fa) {
        // On other classes marshal all fields
        if (!fa.getDeclaringClass().equals(Greeting.class)) {
            return false;
        }
        // On Greetings marshal only fields with @Expose annotation
        Annotation exposeAnnotation = fa
                .getAnnotation(com.google.gson.annotations.Expose.class);
        return exposeAnnotation == null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> type) {
        return false;
    }

}
