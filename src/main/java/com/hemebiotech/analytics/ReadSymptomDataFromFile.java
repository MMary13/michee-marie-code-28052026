package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation of ISymptomReader
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String FILEPATH;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.FILEPATH = filepath;
	}



	/**
	 *
	 * @return Map<String, Integer> with each type of symptom present in a file and
	 * the number of occurrences for each symptom.
	 * Use of a TreeMap to get the result in the right order
	 */
	@Override
	public Map<String, Integer> getSymptomsCounts() {
		Map<String, Integer> symptomsCounts = new TreeMap<>();

		if (FILEPATH != null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(FILEPATH));
				String line;

				while ((line=reader.readLine() )!= null) {
					symptomsCounts.put(line,symptomsCounts.getOrDefault(line,0)+1);
				}
				reader.close();
            } catch (IOException e) {
				//TODO: Better exception treatment
                throw new RuntimeException(e);
            }

        }

		return symptomsCounts;
	}
}
