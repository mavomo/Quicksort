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
		int[] inputData = {3,8,2,5,1,4,7,6};		
		for(int i=0; i<inputData.length; i++){
			System.out.println("" + inputData[i]);
		}
		
		int[] output = partitionize(inputData);

		System.out.println("============== Partionized version ================");
		
		for(int i=0; i< output.length; i++){
			System.out.println("" + output[i]);
		}
	}
	
	
	
	private static int[] partitionize(int[] inputArray){
		//At first, we consider the pivot as the first entry of our array.
		int pivot = inputArray[0];
		int counterRight = 1;
		int counterLeft = 1;
		System.out.println("<p limit "+ inputArray[counterLeft]+1);
		for(int i=1; i< inputArray.length; i++){
			//If the current input is lower that the pivot then swap pivots.
		 if(inputArray[i] < pivot){
			 int tmp = inputArray[i];
			 inputArray[i] = inputArray[counterRight];
			 inputArray[counterRight] = tmp;
			 counterRight++;
			 counterLeft++;
		 }
		}
		//Putting the pivot at the right position 
		inputArray[0] = inputArray[counterLeft-1];
		inputArray[counterLeft-1] = pivot;
		return inputArray;
	}	
	
	
}
