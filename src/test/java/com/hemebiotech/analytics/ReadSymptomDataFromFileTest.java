package com.hemebiotech.analytics;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReadSymptomDataFromFileTest {
    private static ReadSymptomDataFromFile instance;

    @Test
    void testReadSymptomDataFromFile() {
        String filePath = "src/test/resources/symptoms-test.txt";
        instance = new ReadSymptomDataFromFile(filePath);
        Map<String, Integer> symptoms = instance.getSymptomsCounts();
        assertNotNull(symptoms);
        assertEquals(3, symptoms.get("headache"));
    }

    @Test
    void failToReadSymptomDataFromFileWithWrongPath() {
        String wrongPath = "src//resources/symptoms-test.txt";
        instance = new ReadSymptomDataFromFile(wrongPath);
        assertThrows(RuntimeException.class, instance::getSymptomsCounts);

    }
}
