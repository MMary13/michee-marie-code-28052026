package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


/**
 * Implementation of {@link ISymptomWriter} that writes symptom occurrence
 * counts to an output file.
 * The generated file contains one symptom per line along with its associated
 * count.
 */
public class WriteSymptomDataToFile implements ISymptomWriter{

    public WriteSymptomDataToFile() {
    }

    /**
     * Generates the {@code result.out} file containing all symptoms and their
     * corresponding occurrence counts.
     *
     * @param symptomsCounts a map of symptoms and their occurrence counts
     * @throws RuntimeException if an I/O error occurs while writing the output file
     */
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
