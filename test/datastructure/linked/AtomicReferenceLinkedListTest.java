package datastructure.linked;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class AtomicReferenceLinkedListTest {

   private AtomicReferenceLinkedList<String> _atomicListEmpty;
   private AtomicReferenceLinkedList<String> _atomicListNotEmpty;

   @Before
   public void setUpMethod() throws Exception {
      _atomicListEmpty = new AtomicReferenceLinkedList<>();
      List<String> origList = Arrays.asList("one", "two", "three");
      _atomicListNotEmpty = new AtomicReferenceLinkedList<>(origList);
   }

   @Test
   public void testCopyConstructor() throws Exception {
      AtomicReferenceLinkedList<String> copyList =
            new AtomicReferenceLinkedList<>(_atomicListNotEmpty);
//      assertEquals(copyList.size(), 3);
      Iterator<String> copyIter = copyList.iterator();
      assertEquals(copyIter.next(), "one");
      assertEquals(copyIter.next(), "two");
      assertEquals(copyIter.next(), "three");
   }

   @Test
   public void testCopyConstructorWhenEmpty() throws Exception {
      AtomicReferenceLinkedList<String> copyList =
            new AtomicReferenceLinkedList<>(_atomicListEmpty);
//      assertEquals(copyList.size(), 0);
      assertTrue(copyList.isEmpty());
   }

   @Test
   public void testCopyConstructorWhenShutdowned() throws Exception {
      _atomicListNotEmpty.shutdown();
      AtomicReferenceLinkedList<String> copyList =
            new AtomicReferenceLinkedList<>(_atomicListNotEmpty);
//      assertEquals(copyList.size(), 3);
      Iterator<String> copyIter = copyList.iterator();
      assertEquals(copyIter.next(), "one");
      assertEquals(copyIter.next(), "two");
      assertEquals(copyIter.next(), "three");
   }

   @Test
   public void testSize() throws Exception {
//      assertEquals(_atomicListNotEmpty.size(), 3);
   }

   @Test
   public void testAdd() throws Exception {
      _atomicListNotEmpty.add("four");
      _atomicListNotEmpty.add("five");
//      assertEquals(_atomicListNotEmpty.size(), 5);
      Iterator<String> iter = _atomicListNotEmpty.iterator();
      assertEquals(iter.next(), "five");
      assertEquals(iter.next(), "four");
      assertEquals(iter.next(), "three");
      assertEquals(iter.next(), "two");
      assertEquals(iter.next(), "one");
   }

   @Test
   public void testIterate() throws Exception {
//      assertEquals(_atomicListNotEmpty.size(), 3);
      Iterator<String> iter = _atomicListNotEmpty.iterator();
      assertEquals(iter.next(), "three");
      assertEquals(iter.next(), "two");
      assertEquals(iter.next(), "one");
   }

   @Test(
         expected = NoSuchElementException.class)
   public void testIterateBehindBoundsWhenEmpty() throws Exception {
      _atomicListEmpty.iterator().next();
   }

   @Test(
         expected = NoSuchElementException.class)
   public void testIterateBehindBoundsWhenNotEmpty() throws Exception {
      Iterator<String> iter = _atomicListNotEmpty.iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
   }

   @Test
   public void testIterateWhenInitialyShutdowned() throws Exception {
//      assertEquals(_atomicListNotEmpty.size(), 3);
      _atomicListNotEmpty.shutdown();
      Iterator<String> iter = _atomicListNotEmpty.iterator();
      assertEquals(iter.next(), "three");
      assertEquals(iter.next(), "two");
      assertEquals(iter.next(), "one");
   }

   @Test
   public void testIterateDuringShutdown() throws Exception {
//      assertEquals(_atomicListNotEmpty.size(), 3);
      Iterator<String> iter = _atomicListNotEmpty.iterator();
      assertEquals(iter.next(), "three");
      _atomicListNotEmpty.shutdown();
      assertEquals(iter.next(), "two");
      assertEquals(iter.next(), "one");
   }

   @Test
   public void testIteratorHasNextWhenEmpty() throws Exception {
      assertFalse(_atomicListEmpty.iterator().hasNext());
   }

   @Test
   public void testIteratorHasNextWhenNotEmpty() throws Exception {
      assertTrue(_atomicListNotEmpty.iterator().hasNext());
   }

   @Test(
         expected = UnsupportedOperationException.class)
   public void testIteratorRemove() throws Exception {
//      assertEquals(_atomicListNotEmpty.size(), 3);
      Iterator<String> iter = _atomicListNotEmpty.iterator();
      assertEquals(iter.next(), "three");
      iter.remove();
   }

   @Test
   public void testIsEmptyWhenEmpty() throws Exception {
      assertTrue(_atomicListEmpty.isEmpty());
   }

   @Test
   public void testIsEmptyWhenNotEmpty() throws Exception {
      assertFalse(_atomicListNotEmpty.isEmpty());
   }

   @Test
   public void testIsEmptyWhenNotEmptyButShutdowned() throws Exception {
      _atomicListNotEmpty.shutdown();
      assertFalse(_atomicListNotEmpty.isEmpty());
   }

//   @Test
//   public void testSizeWhenEmpty() throws Exception {
//      assertEquals(_atomicListEmpty.size(), 0);
//   }

//   @Test
//   public void testSizeWhenNotEmpty() throws Exception {
//      assertEquals(_atomicListNotEmpty.size(), 3);
//   }

//   @Test
//   public void testSizeWhenNotEmptyButShutdowned() throws Exception {
//      _atomicListNotEmpty.shutdown();
//      assertEquals(_atomicListNotEmpty.size(), 3);
//   }

   @Test(
         expected = IllegalStateException.class)
   public void testAddWhenShutdowned() throws Exception {
      _atomicListNotEmpty.shutdown();
      _atomicListNotEmpty.add("three");
   }

   @Test
   public void testShutdownWhenEmpty() throws Exception {
      _atomicListEmpty.shutdown();
      assertTrue(_atomicListEmpty.isEmpty());
//      assertEquals(_atomicListEmpty.size(), 0);
   }

   @Test
   public void testShutdownWhenNotEmpty() throws Exception {
      _atomicListNotEmpty.shutdown();
      assertFalse(_atomicListNotEmpty.isEmpty());
//      assertEquals(_atomicListNotEmpty.size(), 3);
   }

   @Test
   public void testShutdownWhenCopied() throws Exception {
      AtomicReferenceLinkedList<String> copyList = new AtomicReferenceLinkedList<>(_atomicListNotEmpty);
      copyList.shutdown();
//      assertEquals(copyList.size(), 3);
      Iterator<String> iter = copyList.iterator();
      assertEquals(iter.next(), "one");
      assertEquals(iter.next(), "two");
      assertEquals(iter.next(), "three");
   }

   @Test
   public void testContains() throws Exception {
      assertTrue(_atomicListNotEmpty.contains("three"));
      assertTrue(_atomicListNotEmpty.contains("one"));
      assertTrue(_atomicListNotEmpty.contains("two"));
   }

   @Test
   public void testNotContains() throws Exception {
      assertFalse(_atomicListNotEmpty.contains("four"));
   }

   @Test(
         expected = IllegalStateException.class)
   public void testShutdownWhenShutdowned() throws Exception {
      _atomicListNotEmpty.shutdown();
      _atomicListNotEmpty.shutdown();
   }

}
