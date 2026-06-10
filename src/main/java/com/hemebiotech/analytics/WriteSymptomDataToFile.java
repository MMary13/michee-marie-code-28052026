package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


/**
 * Simple brute force implementation of ISymptomWriter
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter{

    public WriteSymptomDataToFile() {
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptomsCounts) {
        try {
            FileWriter finalWriter =  new FileWriter("result.out");
            symptomsCounts.forEach((symptom, count)->{
                try {
                    finalWriter.write(symptom+":"+count+"\n");
                } catch (IOException e) {
                    //TODO: Better exception treatment
                    throw new RuntimeException(e);
                }
            });
            finalWriter.close();
        } catch (IOException e) {
            //TODO: Better exception treatment
            throw new RuntimeException(e);
        }
    }
}
