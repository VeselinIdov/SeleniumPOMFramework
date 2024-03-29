package core.testdata;

import com.fasterxml.jackson.databind.JsonNode;
import core.objects.ExampleJsonTestData;
import core.utils.JSONUtils;
import lombok.SneakyThrows;

public class RandomJsonDataExample {

    private static final String EXAMPLE_JSON_DATA_PATH = "src/main/resources/exampleJsonData.json";
    private static final String EMPLOYEE_JSON_DATA_PATH = "src/main/resources/EmployeeData.json";

    public static ExampleJsonTestData getExampleJsonData() {
        return JSONUtils.deserializeJSONFile(EXAMPLE_JSON_DATA_PATH, ExampleJsonTestData.class);
    }

    @SneakyThrows
    public static String getEmployeeData(String key, String value) {
        JsonNode jsonArray = JSONUtils.getJSONTree(EMPLOYEE_JSON_DATA_PATH);
        String valueToReturn = "";
        for (JsonNode jsonNode : jsonArray) {
            JsonNode keyNode = jsonNode.get(key);
            if (keyNode != null) {
                valueToReturn = keyNode.get(value).asText();
            }
        }
        return valueToReturn;
    }
}