package org.coursera.algorithm.design.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Common methods.
 * 
 * @author Michelle AVOMO
 *
 */
public class Utils {
	/**
	 * Shows content of the array
	 * @param inputArray : array containing the values
	 */
	public static void displayValues(int[] inputArray) {
		if(inputArray.length == 0){
			System.out.println("The array is empty");
		}
		displaySequence(inputArray);	
	}
	
	/**
	 * Shows the content of arrays stored as keys of the Map and the number of invocation stored as the value of the map
	 * 
	 * @param inputArray: Map containing the values 
	 */	
	public static void displayHashMap(Map<int[], Long> inputArray) {
		if(inputArray.size() == 0){
			System.out.println("The Map is empty");
		}		
		int[] tab = extractArray(inputArray);
		Long val = extractValues(inputArray); 
		displaySequence(tab);
		System.out.println("Total count of inversions : " + val);
	}
	
	public static void displayCountInversion(Map<int[], Long> inputArray){
		if(inputArray.size() == 0){
			System.out.println("The Map is empty");
		}	
		int[] tab = extractArray(inputArray);

		System.out.println("Over #"+ tab.length +" entries, there have been #"+  extractValues(inputArray) + " inversions");

	}

	/**
	 * Format and outputs the sequence in the console.
	 * @param tab : sequence to output
	 */
	public static void displaySequence(int[] tab) {
		String result = ""; 
		for(int index=0; index < tab.length; index++) {
			result += tab[index];
			if(index != tab.length-1){
				result += ",";
			}			
		}	
		System.out.println("** " + result);
	}
	
	/** 
	 * Retrieves the arrays stored as keys of a given map
	 * 
	 * @param inputArray : 
	 * @return
	 */
	public static int[] extractArray(Map<int[], Long> inputArray) {
		int[] leftValues = null;
		for (int[] key : inputArray.keySet() ) {
			//copying the keys from the 
			leftValues = key;
		}
		return leftValues;
	}
	
	/**
	 * Retrieves the values stored in a given map
	 * @param inputArray : map 
	 * @return
	 */
	public static Long extractValues(Map<int[], Long> inputArray) {
		Long value = null;
		for ( Long val : inputArray.values() ) {
			//copying the keys from the 
			value = val;
		}
		return value;
	}
	
	public static InputStreamReader getFile(String filename) {
		InputStream is = Utils.class.getClassLoader().getResourceAsStream(filename);
		return new InputStreamReader(is);
	}
}
