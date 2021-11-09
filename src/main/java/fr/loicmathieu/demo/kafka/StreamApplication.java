package fr.loicmathieu.demo.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import fr.loicmathieu.demo.kafka.binding.Bindings;

/**
 * This is the entry point for the stream application : it contains bindings to topic events.
 *
 *
 * There is a data generator that can be used to test it : LoaderApplication
 *
 * @author lmathieu
 *
 */
@SpringBootApplication
@EnableBinding(Bindings.class)
public class StreamApplication {


    /**
     * This is the main methods : it launch the stream application as a SpringBoot application.
     *
     * @param args
     */
    public static void main(String [] args) {
        SpringApplication.run(StreamApplication.class, args);
    }


    //TODO create a receive method that will handle the data send to the Bindings.RAW_DATA topic
}
