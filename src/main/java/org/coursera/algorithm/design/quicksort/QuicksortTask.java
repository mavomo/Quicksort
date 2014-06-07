package org.coursera.algorithm.design.quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuicksortTask {
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
	public static Integer[] proceedEntry(InputStreamReader isr)
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
		return temp;

	}
}
