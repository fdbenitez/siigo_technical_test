package com.siigo.automation.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class JsonHelper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertToJSON(Object object) {
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return e.toString();
        }
        return json;
    }

    public static String formatJSON(String jsonString) {
        String formattedJSON;
        try {
            Object object = objectMapper.readValue(jsonString, Object.class);
            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
            formattedJSON = objectWriter.writeValueAsString(object);
        } catch (Exception e) {
            return e.toString();
        }
        return formattedJSON;
    }
    public static JSONObject readFileJson(String file) {
        Object ob;
        try {
            ob = new JSONParser().parse(new FileReader(file));
        } catch (IOException|ParseException e) {
            throw new RuntimeException(e);
        }
        return (JSONObject) ob;
    }
}