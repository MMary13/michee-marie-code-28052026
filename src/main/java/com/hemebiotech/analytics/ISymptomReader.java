package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Defines a contract for components that read symptom data from a source.
 *
 * Implementations are responsible for retrieving symptom information and
 * providing the number of occurrences for each symptom.
 */
public interface ISymptomReader {

	/**
	 * Retrieves symptom occurrence counts from a data source.
	 *
	 * The returned map contains symptom names as keys and the number of
	 * occurrences of each symptom as values.
	 *
	 * @return a map containing symptom occurrence counts; returns an empty map
	 *         if no symptom data is available
	 */
	Map<String,Integer> getSymptomsCounts ();

}
