package sorting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import datastructure.StackTest;
import datastructure.linked.LinkedStackTest;

@RunWith(Suite.class)
@SuiteClasses({ InsertionSortTest.class, BulbeSortTest.class, SelectionSortTest.class, MergeSortTest.class, HeapSortTest.class, QuickSortTest.class, 
	StackTest.class, LinkedStackTest.class})
public class AllTests {

}
