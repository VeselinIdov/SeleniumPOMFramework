package core.testdata;

import core.dto.ExampleJsonTestData;
import core.utils.JsonExtractor;

import java.util.List;

public class RandomJsonDataExample {

    public ExampleJsonTestData getJsonCarName(){
        String file = "src/main/resources/exampleJsonData.json";

        ExampleJsonTestData[] data = JsonExtractor.objectMapper(file, ExampleJsonTestData[].class);
        ExampleJsonTestData items = new ExampleJsonTestData();
        for (ExampleJsonTestData item : data) {
            items = item;
        }
        return items;
    }

    public ExampleJsonTestData getJsonCarName(String value){
        String file = "src/main/resources/exampleJsonData.json";
        ExampleJsonTestData[] data = JsonExtractor.objectMapper(file, ExampleJsonTestData[].class);
        ExampleJsonTestData result = new ExampleJsonTestData();

        for (ExampleJsonTestData jsonData : data) {
            List<String> cars = jsonData.getCars();
                for (String car : cars) {
                    if (car.equals(value)) {
                        result = jsonData;
                        break;
                    }
            }
        }
        return result;
    }
}
