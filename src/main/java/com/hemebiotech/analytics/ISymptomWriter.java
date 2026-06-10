package com.hemebiotech.analytics;


import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write in the output file
 *
 */
public interface ISymptomWriter {

    /**
     *
     */
    public void writeSymptoms (Map<String,Integer> symptomsCounts);
}
