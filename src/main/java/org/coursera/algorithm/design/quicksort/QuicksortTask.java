package org.coursera.algorithm.design.quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.coursera.algorithm.design.utils.Utils;

public class QuicksortTask {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr10Entries = Utils.getFile("sequence10.txt");
		Integer[] output10 = processEntry(isr10Entries);
		
		System.out.println("======================== Programming Assignement - week 2 - 10 entries ==============================");
		
		InputStreamReader isr100Entries = Utils.getFile("sequence100.txt");
		Integer[] output100 = processEntry(isr100Entries);
		
		System.out.println("======================== Programming Assignement - week 2 - 100 entries ==============================");

		InputStreamReader isr1000Entries = Utils.getFile("sequence100.txt");
		Integer[] output1000 = processEntry(isr1000Entries);
		
		System.out.println("======================== Programming Assignement - week 2 - 1000 entries ==============================");
	}

	/**
	 * Builds an array containing the sequence of a given file then apply the
	 * count inversion algorithm
	 * 
	 * @param isr
	 *            : stream to read
	 * @return a map containing a sorted array and the number of inversions that
	 *         occured.
	 * @throws IOException
	 */
	public static Integer[] processEntry(InputStreamReader isr)
			throws IOException {
		List<Integer> entrySequence = new ArrayList<>();

		if (isr != null) {
			BufferedReader br = new BufferedReader(isr);
			String lineContent = null;
			// Copy the lines into an array
			while ((lineContent = br.readLine()) != null) {
				entrySequence.add(Integer.parseInt(lineContent.trim()));
			}
		}
		Integer[] temp = entrySequence.toArray(new Integer[0]);
		Quicksort.quicksortAndCountComparison(entrySequence.toArray(new Integer[0]), 0, temp.length);

		return temp;

	}
}
