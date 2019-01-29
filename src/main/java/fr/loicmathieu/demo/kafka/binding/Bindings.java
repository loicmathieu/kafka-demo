package fr.loicmathieu.demo.kafka.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * This is where the spring-steam-kafka magic happens.
 * Each binding to a topic needs to be defined here with a logical name, this logical name will be used in both the application.yml file to reference the real topic and configure the consumer/producer
 * then in the StreamApplication to define which method will handle the message.
 *
 * Each channel needs to be defined with an abstract method with a SubscribleChannel/@Input topic (for message consumer) and MessageChannel/@Output topic (for message producer)
 * @author lmathieu
 *
 */
public interface Bindings {
    public static String RAW_DATA = "RAW_DATA";

    @Input(RAW_DATA)
    public SubscribableChannel rawDataInput();
}
