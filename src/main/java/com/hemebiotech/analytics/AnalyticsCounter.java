package com.hemebiotech.analytics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Entry point of the Hemebiotech analytics application.
 * <p>
 * This class coordinates the symptom analysis process by:
 * <ul>
 *     <li>Reading symptom data from the input file</li>
 *     <li>Counting the occurrences of each symptom</li>
 *     <li>Writing the aggregated results to an output file</li>
 * </ul>
 */
public class AnalyticsCounter {
    private static final Logger logger = LogManager.getLogger(AnalyticsCounter.class);

    /**
     * Starts the symptom analytics process.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        logger.info("Starting symptom analytics process");
        // Read the input file and count symptom occurrences
        ReadSymptomDataFromFile inputFile = new ReadSymptomDataFromFile("src/symptoms.txt");
        Map<String, Integer> symptomsCounts = inputFile.getSymptomsCounts();

        //Write the results to the output file
        WriteSymptomDataToFile outputFile = new WriteSymptomDataToFile("result.out");
        outputFile.writeSymptoms(symptomsCounts);
        logger.info("Process ended: results have been generated in an output file");
    }
}