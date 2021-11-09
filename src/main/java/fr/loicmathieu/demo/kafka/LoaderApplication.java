package fr.loicmathieu.demo.kafka;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


/**
 * This is an utility class to be able to generate fake data.
 * Launch it and it will generate 1000 events in the kafka topic that the application listen to.
 *
 * @author lmathieu
 */
public class LoaderApplication {
    private static final String TOPIC = "demo.raw_data";


    /**
     * The run of the application : generate 1000 data, send them to kafka and stop
     */
    public static void main(String[] args) {
    	// properties for the Kafka producer
    	Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        
        try(Producer<String, String> producer = new KafkaProducer<>(props)){
	        for(int i=0; i<1000; i++) {
	            String msg = "TEXT" + i + ";" + i + ";" + LocalDateTime.now().plusDays(1);
	
	            producer.send(new ProducerRecord<>(TOPIC, UUID.randomUUID().toString(), msg));
	        }
        }
    }

}
