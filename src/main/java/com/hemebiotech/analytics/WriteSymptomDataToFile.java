package com.hemebiotech.analytics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


/**
 * Implementation of {@link ISymptomWriter} that writes symptom occurrence
 * counts to an output file.
 * The generated file contains one symptom per line along with its associated
 * count.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepath;
    private static final Logger logger = LogManager.getLogger(WriteSymptomDataToFile.class);

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
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
            FileWriter finalWriter = new FileWriter(filepath);
            symptomsCounts.forEach((symptom, count) -> {
                try {
                    finalWriter.write(symptom + ":" + count + "\n");
                } catch (IOException e) {
                    logger.error("Unable to write the output file:", e);
                    throw new IllegalStateException("Unable to write the output file", e);
                }
            });
            finalWriter.close();
        } catch (IOException e) {
            logger.error("Unable to write the output file:", e);
            throw new IllegalStateException("Unable to write the output file", e);
        }
    }
}
