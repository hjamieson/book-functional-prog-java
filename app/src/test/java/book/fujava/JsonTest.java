package book.fujava;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonTest {

    private final File sampleFile = new File("src/test/resources/sample1.json");
    private final JsonFactory factory = JsonFactory.builder()
            .enable(JsonReadFeature.ALLOW_JAVA_COMMENTS)
            .build();

    @Test
    void createFactory(){
        try {
            JsonParser parser = factory.createParser(sampleFile);
            JsonToken token = parser.nextToken();
            System.out.println(token);
            parser.close();

        } catch (IOException e) {
            fail(e);
        }
    }

    @Test
    void readTree(){
        try {
            ObjectMapper om = new ObjectMapper();
            JsonNode root = om.readTree(sampleFile);
            assert(root.isObject());
            JsonNode count = root.get("count");
            System.out.println(count.getNodeType());
            assert(count.asInt() == 1);
            JsonNode results = root.get("results"); // results is an ARRAY!
            System.out.println(results.getNodeType());
            JsonNode close = results.get(0).get("c");
            assertEquals(close.asDouble(), 152.55, 0.001);

        } catch (IOException e) {
            fail(e);
        }
    }

    @Test
    void restTreeQuick(){
        ObjectMapper om = new ObjectMapper();
        try {
            double actual = om.readTree(sampleFile).get("results").get(0).get("c").asDouble();
            assertEquals(152.55, actual, .0001);
        } catch (IOException e) {
            fail(e);
        }
    }
}
