package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import sorting.BulbeSortTest;
import sorting.HeapSortTest;
import sorting.InsertionSortTest;
import sorting.MergeSortTest;
import sorting.QuickSortTest;
import sorting.SelectionSortTest;
import datastructure.StackTest;
import datastructure.linked.LinkedQueueTest;
import datastructure.linked.LinkedStackTest;

@RunWith(Suite.class)
@SuiteClasses({ InsertionSortTest.class, BulbeSortTest.class, SelectionSortTest.class, MergeSortTest.class, HeapSortTest.class, QuickSortTest.class, 
	StackTest.class, LinkedStackTest.class, LinkedQueueTest.class})
public class AllTests {

}
