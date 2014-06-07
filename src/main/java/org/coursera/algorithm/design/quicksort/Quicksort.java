package org.coursera.algorithm.design.quicksort;

/**
 * Class implementing the quicksort algorithm
 * 
 * @author Michelle AVOMO
 *
 */
public class Quicksort {
	
	protected static long nbComparison;
	
	/***
	 * Quicksort algotithm implementation using the first element as the pivot.
	 * @param inputArray
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static Integer[] partitionizeAndSort(Integer[] inputArray, int startIndex, int endIndex){
		//Base case
		if(startIndex >= endIndex){
			return inputArray;
		}else{
		//General case			
		int newPivot = partitionize(inputArray, startIndex, endIndex);
		nbComparison += endIndex - startIndex;
		//Left subarray		
		partitionizeAndSort(inputArray, startIndex, newPivot-1);
		//right subarray
		partitionizeAndSort(inputArray, newPivot+1, endIndex);
		 
		}
		return inputArray;
	}	
		
	/**
	 * Partitionning method that takes the first element of the array as its pivot
	 * @param inputArray : array to be sorted
	 * @param start: first element of the array
	 * @param end : last element in the array
	 * @return the new pivot of the array around which we'll partition the array
	 */
	private static int partitionize(Integer[] inputArray, int start, int end){
		//The pivot corresponds to the first element of the Array		  
		int pivot = inputArray[start];	
		//Boundary of the latest element <p
		int innerCounter = start + 1;
		for (int i = start + 1; i <= end; i++) {
			// If the current input is lower that the pivot then swap pivots.
				if (inputArray[i] < pivot) {
					//nbComparison++;
					int tmp = inputArray[i];
					inputArray[i] = inputArray[innerCounter];
					inputArray[innerCounter] = tmp;
					innerCounter++;
				}			
		}
		swap(inputArray, start, innerCounter);		
		return innerCounter-1;	
	}
	
	
	/***
	 * Quicksort algotithm implementation using the last element as the pivot.
	 * @param inputArray
	 * @param startIndex
	 * @param endIndex
	 * @return the sorted version of the array and subarrays when recursively called.
	 */
	public static Integer[] partitionizeUsingLastElementAndSort(Integer[] inputArray, int startIndex, int endIndex){
		//Base case
		if(startIndex >= endIndex){
			return inputArray;
		}else{
		//General case			
		int newPivot = partitionizePivotAsLast(inputArray, startIndex, endIndex);
		nbComparison += endIndex - startIndex;
		//Left subarray		
		partitionizeUsingLastElementAndSort(inputArray, startIndex, newPivot-1);
		//right subarray
		partitionizeUsingLastElementAndSort(inputArray, newPivot+1, endIndex);
		 
		}
		return inputArray;
	}	
	
	
	/***
	 * Quicksort algotithm implementation using the "medium-of-three" as a pivot.
	 * @param inputArray
	 * @param startIndex
	 * @param endIndex
	 * @return 
	 */
	public static Integer[] partitionizeUsingMediumOfThreeAndSort(Integer[] inputArray, int startIndex, int endIndex){
		//Base case
		if(startIndex >= endIndex){
			return inputArray;
		}else{
		//General case			
		int newPivot = partitionizePivotAsMediumOfThree(inputArray, startIndex, endIndex);
		nbComparison += endIndex - startIndex;
		//Left subarray		
		partitionizeUsingMediumOfThreeAndSort(inputArray, startIndex, newPivot-1);
		//right subarray
		partitionizeUsingMediumOfThreeAndSort(inputArray, newPivot+1, endIndex);
		 
		}
		return inputArray;
	}
	
	
	/**
	 * Partitionning method that uses the median-of-three privot rule
	 * @param inputArray : array to be sorted
	 * @param start: first element of the array
	 * @param end : last element in the array
	 * @return the new pivot of the array around which we'll partition the array
	 */
	private static int partitionizePivotAsMediumOfThree(Integer[] inputArray, int start, int end){
		//Switching the last element to be the first before partition		  
		int firstElement = inputArray[start];
		int finalElement = inputArray[end];
		//Length of the subarray
		int medianIndex =  start + (end - start)/2;	
		//Position of the middle element into the initial array
		
		int middleElement = inputArray[(medianIndex)];
		int median = start;
		//Rearrange the array in  sorted order
		if((firstElement > middleElement && firstElement < finalElement) || (firstElement < middleElement && finalElement > finalElement)){
			median = start;
		}
		if((middleElement > firstElement && middleElement < finalElement) || (middleElement < firstElement && middleElement > finalElement)){
			median = medianIndex;
		}
		if((finalElement > firstElement && finalElement<middleElement) || (finalElement < firstElement && finalElement > middleElement)){
			median = end;
		}	
		//Swapping elements to the head of the array before processing
		if(median != start){
			int tmpValue = inputArray[median];
			inputArray[median] = inputArray[start];
			inputArray[start] = tmpValue;
		}
				
		//Putting the last element as the first
		int pivot = inputArray[start];	
		
		//Boundary of the latest element <p
		int innerCounter = start + 1;
		for (int i = start + 1; i <= end; i++) {
			// If the current input is lower that the pivot then swap pivots.
				if (inputArray[i] < pivot) {
					int tmp = inputArray[i];
					inputArray[i] = inputArray[innerCounter];
					inputArray[innerCounter] = tmp;
					innerCounter++;
				}			
		}
		swap(inputArray, start, innerCounter);		
		return innerCounter-1;	
	}
	
	
	
	/**
	 * Partitionning method that takes the last element of the array as its pivot
	 * @param inputArray : array to be sorted
	 * @param start: first element of the array
	 * @param end : last element in the array
	 * @return the new pivot of the array around which we'll partition the array
	 */
	private static int partitionizePivotAsLast(Integer[] inputArray, int start, int end){
		//Switching the last element to be the first before partition		  
		int tmpEndCpy = inputArray[end];
		inputArray[end] = inputArray[start];
		inputArray[start] = tmpEndCpy;
		
		//Putting the last element as the first
		int pivot = inputArray[start];	
		
		//Boundary of the latest element <p
		int innerCounter = start + 1;
		for (int i = start + 1; i <= end; i++) {
			// If the current input is lower that the pivot then swap pivots.
				if (inputArray[i] < pivot) {
					int tmp = inputArray[i];
					inputArray[i] = inputArray[innerCounter];
					inputArray[innerCounter] = tmp;
					innerCounter++;
				}			
		}
		//Putting the pivot at the right position
		swap(inputArray, start, innerCounter);		
		return innerCounter-1;	
	}

	private static void swap(Integer[] inputArray, int start, int innerCounter) {
		int tmp = inputArray[start]; 
		inputArray[start] = inputArray[innerCounter-1];
		inputArray[innerCounter-1] = tmp;
	}
	
	

	
	
	
	public static long getNbComparison() {
		return nbComparison;
	}


	public static void setNbComparison(int nbComparison) {
		Quicksort.nbComparison = nbComparison;
	}
	
}
