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
		int[] inputData = {5,3,6,4,8,0,1};
		
		for(int i=0; i< inputData.length; i++){
			System.out.println(inputData[i]);
		}
		System.out.println("=============== Partionning and sorting ==============");
		partitionizeAndSort(inputData, 0, inputData.length);
		
		for(int i=0; i< inputData.length; i++){
			System.out.println(inputData[i]);
		}

		
	}
	
	public static void partitionizeAndSort(int[] inputArray, int startIndex, int endIndex){
		//General case 
		//Position of the partition index
		int nouveauPivot = partitionize(inputArray, startIndex, endIndex);
		if(startIndex < nouveauPivot - 1){
			partitionizeAndSort(inputArray, startIndex, nouveauPivot);	
		}else {
			if(nouveauPivot+1 < endIndex+1){
			partitionizeAndSort(inputArray, nouveauPivot, endIndex);
			}
		}
				
		
			
	}
	
	private static int partitionize(int[] inputArray, int start, int end){
		//At first, we consider the pivot as the first entry of our array.
		  
			int pivot=inputArray[start];							
			//Boundary of the latest element <p
			int innerCounter = start+1;	
				for(int i=start+1; i< end; i++){
					//If the current input is lower that the pivot then swap pivots.
					if(i < inputArray.length){
						 if(inputArray[i] <= pivot){
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
