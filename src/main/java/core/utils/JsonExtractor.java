package core.utils;

import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.*;

public class JsonExtractor {
    public static <P> P deserializeResponse(String jsonResponse, Class<P> cls) {
        Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(jsonResponse, cls);
    }

    @SneakyThrows
    public static <P> P objectMapper(String filePath, Class<P> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}