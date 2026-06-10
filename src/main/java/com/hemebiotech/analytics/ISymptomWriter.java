package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Defines a contract for writing symptom occurrence data to an output destination.
 *
 * Implementations may write the data to a file, a database, a web service,
 * or any other target capable of storing or displaying symptom information.
 */

public interface ISymptomWriter {

    /**
     * Writes symptoms and their occurrence counts to an output destination.
     *
     * The provided map contains symptom names as keys and their corresponding
     * occurrence counts as values.
     *
     * @param symptomsCounts a map containing symptom occurrence counts
     */
    public void writeSymptoms (Map<String,Integer> symptomsCounts);
}
