package org.coursera.algorithm.design.quicksort;

import java.io.IOException;

/**
 * Class implementing the quicksort algorithm
 * 
 * @author Michelle AVOMO
 *
 */
public class Quicksort {
	
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
	}
	
	public static int[] partitionizeAndSort(int[] inputArray, int startIndex, int endIndex){
		//Base case
		if (endIndex-1 <= startIndex){
			return inputArray;
		}else{
			//General case
			int nouveauPivot = partitionize(inputArray, startIndex, endIndex);
			partitionizeAndSort(inputArray, startIndex, nouveauPivot);	
			partitionizeAndSort(inputArray, nouveauPivot, endIndex);	
			return inputArray;
		}
		
	}
	
	/**
	 * Partitionning method that takes the first element of the array as its pivot
	 * @param inputArray : array to be sorted
	 * @param start: first element of the array
	 * @param end : last element in the array
	 * @return an array containing the pivot at its right position with all the lower numbers in the left and all the upper ones in the left of the pivot
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
}
