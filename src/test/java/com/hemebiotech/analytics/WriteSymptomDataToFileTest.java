package com.hemebiotech.analytics;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class WriteSymptomDataToFileTest {

    @Test
    void shouldWriteSymptomsToFile() throws Exception {

        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("target/test-result.out");
        Map<String, Integer> data = Map.of(
                "headache", 3,
                "fever", 2,
                "cough", 1
        );

        writer.writeSymptoms(data);

        Path file = Path.of("target/test-result.out");
        //check the file exist
        assertTrue(Files.exists(file));

        String content = Files.readString(file);
        //check the content of the file
        assertTrue(content.contains("headache:3"));
        assertTrue(content.contains("fever:2"));
        assertTrue(content.contains("cough:1"));
    }

    @Test
    void shouldCreateEmptyFileWhenMapIsEmpty() throws Exception {

        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("target/test-result.out");

        writer.writeSymptoms(Map.of());
        Path file = Path.of("target/test-result.out");

        assertTrue(Files.exists(file));
        String content = Files.readString(file);
        assertEquals("", content);
    }
}
