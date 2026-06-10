package com.hemebiotech.analytics;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String[] args) {

		// Read the input file & Count the symptoms
		ReadSymptomDataFromFile inputFile = new ReadSymptomDataFromFile("src/symptoms.txt");
		Map<String,Integer> symptomsCounts = inputFile.getSymptomsCounts();

		//Create the output
		WriteSymptomDataToFile outputFile = new WriteSymptomDataToFile();
		outputFile.writeSymptoms(symptomsCounts);
	}
}