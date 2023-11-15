package core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.*;

public class JSONUtils {

    @SneakyThrows
    public static <P> P deserializeResponse(String jsonResponse, Class<P> cls) {
        return new ObjectMapper().readValue(jsonResponse, cls);
    }

    @SneakyThrows
    public static <P> P deserializeJSONFile(String filePath, Class<P> cls) {
        return new ObjectMapper().readValue(new File(filePath), cls);
    }

    @SneakyThrows
    public static JsonNode getJSONTree(String filePath) {
        return new ObjectMapper().readTree(new File(filePath));
    }
}