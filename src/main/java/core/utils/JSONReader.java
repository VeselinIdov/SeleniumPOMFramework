package core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.*;

public class JSONReader {

    public static <P> P deserializeResponse(String jsonResponse, Class<P> cls) {
        Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(jsonResponse, cls);
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