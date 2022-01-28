import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.internals.RecordHeader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) {
        runProducer();
    }

    private static String getThingJson(String filePath) {
        String result = null;
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            JsonObject thingJson = (new Gson().fromJson(reader, JsonObject.class));
//            thingJson.addProperty("name", thingJson.get("name").getAsString() + "_" + (int)(10000 * Math.random()));
            thingJson.remove("thingShape");
            System.out.println("thingJson name: " + thingJson.get("name").getAsString());
            result = thingJson.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result == null ? "{\"a\":\"b\", \"name\":\"WashingMachine123\"}" : result;
    }

    static void runProducer() {
        Producer<String, String> producer = ProducerCreator.createProducer();
        File folder = new File("C:\\developer\\Innovation@PTC\\resources\\populate_data\\12");
        File[] listOfFiles = folder.listFiles();

        for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
            int i = (int) (Math.random() * (40));
//            int i = 0;
            String thingJsonString = getThingJson(listOfFiles[i].getAbsolutePath());
            ProducerRecord<String, String> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME, thingJsonString);
//            record.headers().add(new RecordHeader("Delete", "Delete".getBytes()));
            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            } catch (ExecutionException | InterruptedException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
        }
    }
}
