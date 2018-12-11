package suite;

import datastructure.linked.*;
import ood.patterns.proxy.ProxyTest;

import oop.inherit.concrete.PointMixedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import algo.NODTest;
import algo.NOKTest;
import datastructure.ArrayHeapTest;
import datastructure.ArrayListTest;
import datastructure.ArrayQueueTest;
import datastructure.ArrayStackTest;
import datastructure.PriorityQueueTest;
import debts.DebtReaderTest;
import recursion.FactorielTest;
import recursion.FibonachiTest;
import recursion.ReverseTest;
import sorting.BulbeSortTest;
import sorting.HeapSortTest;
import sorting.InsertionSortTest;
import sorting.MergeSortTest;
import sorting.QuickSortTest;
import sorting.SelectionSortTest;

@RunWith(Suite.class)
@SuiteClasses({InsertionSortTest.class, BulbeSortTest.class, SelectionSortTest.class, MergeSortTest.class, HeapSortTest.class, QuickSortTest.class,
        ArrayStackTest.class, ArrayQueueTest.class, LinkedStackTest.class, LinkedQueueTest.class, LinkedListTest.class, ArrayListTest.class, FactorielTest.class, ReverseTest.class,
        DebtReaderTest.class, FibonachiTest.class, ArrayHeapTest.class, PriorityQueueTest.class, NODTest.class, NOKTest.class, ProxyTest.class, AtomicReferenceLinkedListTest.class,
        PointMixedTest.class})
public class AllTests {

}
