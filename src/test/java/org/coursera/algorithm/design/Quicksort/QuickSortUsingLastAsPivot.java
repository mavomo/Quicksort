package org.coursera.algorithm.design.Quicksort;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStreamReader;

import org.coursera.algorithm.design.quicksort.Quicksort;
import org.coursera.algorithm.design.quicksort.QuicksortTask;
import org.coursera.algorithm.design.utils.Utils;
import org.junit.Before;
import org.junit.Test;

public class QuickSortUsingLastAsPivot {

	@Before
	public void setUp() throws Exception {
		Quicksort.setNbComparison(0);	
	}

	@Test
	public void quicksortsUsingLastAsPivotFor25() throws IOException{
		//Check that the array is sorted as it has to be
		InputStreamReader isr10Entries = Utils.getFile("sequence10.txt");
		Integer[] output10 = QuicksortTask.proceedEntry(isr10Entries);
		Quicksort.partitionizeUsingLastElementAndSort(output10, 0, output10.length-1);
		assertEquals(29, Quicksort.getNbComparison());
	}
	
	@Test
	public void quicksortsUsingLastAsPivotFor100() throws IOException{
		InputStreamReader isr100Entries = Utils.getFile("sequence100.txt");		
		Integer[] output100 = QuicksortTask.proceedEntry(isr100Entries);			
		Quicksort.partitionizeUsingLastElementAndSort(output100, 0, output100.length-1);
		assertEquals(587, Quicksort.getNbComparison());
	}
	
	@Test
	public void quicksortsUsingLastAsPivotFor1000() throws IOException{
		InputStreamReader isr1000EntriesCpy = Utils.getFile("sequence1000.txt");
		Integer[] output1000 =QuicksortTask.proceedEntry(isr1000EntriesCpy);
		Quicksort.partitionizeUsingLastElementAndSort(output1000, 0, output1000.length-1);
		assertEquals(10184, Quicksort.getNbComparison());
	}
	
	@Test
	public void quicksortsAndCountComparisons10000() throws IOException{
		InputStreamReader isr10000EntriesCpy = Utils.getFile("10000.txt");
		Integer[] output1000 =QuicksortTask.proceedEntry(isr10000EntriesCpy);
		Quicksort.partitionizeUsingLastElementAndSort(output1000, 0, output1000.length-1);
		System.out.println(":::" + Quicksort.getNbComparison());
	}

}
