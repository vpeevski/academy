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
import datastructure.ArrayListTest;
import datastructure.ArrayQueueTest;
import datastructure.ArrayStackTest;
import datastructure.linked.LinkedListTest;
import datastructure.linked.LinkedQueueTest;
import datastructure.linked.LinkedStackTest;

@RunWith(Suite.class)
@SuiteClasses({ InsertionSortTest.class, BulbeSortTest.class, SelectionSortTest.class, MergeSortTest.class, HeapSortTest.class, QuickSortTest.class, 
	ArrayStackTest.class, ArrayQueueTest.class, LinkedStackTest.class, LinkedQueueTest.class, LinkedListTest.class, ArrayListTest.class})
public class AllTests {

}
