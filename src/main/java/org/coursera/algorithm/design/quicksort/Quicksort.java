package org.coursera.algorithm.design.quicksort;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



/**
 * Class implementing the quicksort algorithm
 * 
 * @author Michelle AVOMO
 *
 */
public class Quicksort {
	
	private static Long nbComparison=0L;
	
	public static void main(String[] args) throws IOException {
		//int[] inputData = {5,3,6,4,8,0,1};
		int[] inputData = {6,5,4,3,2,1,0};
		
		for(int i=0; i< inputData.length; i++){
			System.out.println(inputData[i]);
		}
		System.out.println("=============== Partionning and sorting ==============");
		partitionizeAndSort(inputData, 0, inputData.length);		
		for(int i=0; i< inputData.length; i++){
			System.out.println(inputData[i]);
		}		
		
		int[] testEntries = {3,9,8,4,6,10,2,5,7,1};		
		
		int[] outputEntries = quicksortAndCountComparison(testEntries, 0, testEntries.length);
		
		System.out.println("=============== Quicksort and counting inversions ==============");
		//System.out.println("Nb comparison " + nbComparison);
		System.out.println(outputEntries.length + nbComparison);
		
	}
	
	/***
	 * Quicksort algotithm implementation
	 * @param inputArray
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static int[] partitionizeAndSort(int[] inputArray, int startIndex, int endIndex){
		//Base case
		if (endIndex-1 <= startIndex){
			return inputArray;
		}else{
			//General case
			int newPivot = partitionize(inputArray, startIndex, endIndex);
			partitionizeAndSort(inputArray, startIndex, newPivot);	
			partitionizeAndSort(inputArray, newPivot, endIndex);	
			return inputArray;
		}
	}
	
	public static int[] quicksortAndCountComparison(int[] inputArray, int startIndex, int endIndex){	
		Map<int[], Long> output = new HashMap<>();
		if (endIndex-1 <= startIndex){
			return inputArray;
		}else{			
			//General case		
			nbComparison++;
			int newPivot = partitionizeV2(inputArray, startIndex, endIndex);			
			quicksortAndCountComparison(inputArray, startIndex, newPivot);			
			quicksortAndCountComparison(inputArray, newPivot, endIndex);
		
			
			return inputArray;
		}
	}
	
	/**
	 * Partitionning method that takes the first element of the array as its pivot
	 * @param inputArray : array to be sorted
	 * @param start: first element of the array
	 * @param end : last element in the array
	 * @return the new pivot of the array around which we'll partition the array
	 */
	private static int partitionize(int[] inputArray, int start, int end){
		//The pivot corresponds to the first element of the Array		  
			int pivot=inputArray[start];							
			//Boundary of the latest element <p
		int innerCounter = start + 1;
		for (int i = start + 1; i < end; i++) {
			// If the current input is lower that the pivot then swap pivots.
			if (i < inputArray.length) {
				if (inputArray[i] <= pivot) {
					int tmp = inputArray[i];
					inputArray[i] = inputArray[innerCounter];
					inputArray[innerCounter] = tmp;
					innerCounter++;
				}
			}
		}
		//Putting the pivot at the right position
		int tmp = inputArray[start]; 
		inputArray[start] = inputArray[innerCounter-1];
		inputArray[innerCounter-1] = tmp;
		return innerCounter;
	
	}
	
	/**
	 * Partitionning method that takes the first element of the array as its pivot
	 * @param inputArray : array to be sorted
	 * @param start: first element of the array
	 * @param end : last element in the array
	 * @return the new pivot of the array around which we'll partition the array
	 */
	private static int partitionizeV2(int[] inputArray, int start, int end){
		//The pivot corresponds to the first element of the Array	
		Map<Integer, Long> result = new HashMap<>();
		
		int pivot=inputArray[start];							
		//Boundary of the latest element <p
		int innerCounter = start + 1;
		for (int i = start + 1; i < end; i++) {
			// If the current input is lower that the pivot then swap pivots.
			if (i < inputArray.length) {
				if (inputArray[i] <= pivot) {
					int tmp = inputArray[i];
					inputArray[i] = inputArray[innerCounter];
					inputArray[innerCounter] = tmp;
					innerCounter++;
					nbComparison++;
				}
			}
		}
		
		//Putting the pivot at the right position
		int tmp = inputArray[start]; 
		inputArray[start] = inputArray[innerCounter-1];
		inputArray[innerCounter-1] = tmp;
		return innerCounter;
	
	}
	
	
}
