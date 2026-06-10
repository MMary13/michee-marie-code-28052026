package com.hemebiotech.analytics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation of {@link ISymptomReader} that reads symptom data from a text file.
 *
 * The input file is expected to contain one symptom per line. This class
 * counts the occurrences of each symptom and returns the results as a map,
 * where the key is the symptom name and the value is the number of times
 * the symptom appears in the file.
 *
 * The returned map is sorted alphabetically by symptom name.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	private static final Logger logger =
			LogManager.getLogger(ReadSymptomDataFromFile.class);

	/**
	 * Creates a reader that retrieves symptom data from the specified file.
	 *
	 * @param filepath the path to the input file containing symptom names,
	 *                 one symptom per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}



	/**
	 * Reads the input file and counts the occurrences of each symptom.
	 *
	 * The returned map contains one entry per distinct symptom found in the file.
	 * Keys represent symptom names and values represent the number of occurrences.
	 * The map is sorted alphabetically by symptom name.
	 *
	 * @return a sorted map containing symptoms and their occurrence counts
	 * @throws RuntimeException if an I/O error occurs while reading the file
	 */
	@Override
	public Map<String, Integer> getSymptomsCounts() {
		Map<String, Integer> symptomsCounts = new TreeMap<>();

		if (filepath != null) {
            try {
				BufferedReader reader =  new BufferedReader(new FileReader(filepath));
				String line;

				while ((line=reader.readLine() )!= null) {
					symptomsCounts.put(line,symptomsCounts.getOrDefault(line,0)+1);
				}
				reader.close();
            } catch (IOException e) {
				logger.error("Unable to read symptom file: {}", filepath, e);
                throw new RuntimeException(e);
            }

        }

		return symptomsCounts;
	}
}
