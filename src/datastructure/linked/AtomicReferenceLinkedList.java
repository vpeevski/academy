package datastructure.linked;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Thread-safe, non-blocking linked list holding items of generic type E.
 * Concrete types of E are meant to be some kind of listeners, which are
 * critically to be called on some events that have happened in the future or in
 * the past.
 *
 * Typical usage:
 *
 * <code>
 * SomeListener listener = new SomeListener();
 * AtomicReferenceLinkedList<SomeListener> l = new AtomicReferenceLinkedList<>();
 * try {
 *    l.add(listener);
 * } catch (IllegalStateException e) {
 *    listener.callback(); // list has been shutdown by some other thread in the past
 * }
 * </code>
 *
 * It is caller's responsibility to call {@link #shutdown()} method as some
 * termination event occur in some time, and after this event occurs addition of
 * new the listeners is no more needed. All other thread trying to add listeners
 * will receive IllegalStateException and thus will be informed to perform all
 * necessary cleanup.
 *
 * The list will be ready to be disposed as soon as all listeners are notified.
 *
 * When the termination event occur :
 *
 * l.shutDown(); // list is closed for adding, add operations will throw
 *               // IllegalStateException after this point
 * for(Listener listener : l) {
 *    listener.callback();
 * }
 *
 * @author vpeevski
 *
 * @param <E>
 */
public final class AtomicReferenceLinkedList<E> implements Iterable<E> {

   private final ListItem<E> SENTINEL_VALUE;

   private final AtomicReference<ListItem<E>> _head;

   // private AtomicInteger _size;

   /**
    * Creates an empty instance of AtomicReferenceLinkedList
    */
   public AtomicReferenceLinkedList() {
      _head = new AtomicReference<>(null);
      SENTINEL_VALUE = new ListItem<>(null, _head.get());
      // _size = new AtomicInteger(0);
   }

   /**
    * Creates an instance of AtomicReferenceLinkedList containing all items
    * contained in sourceList argument
    *
    * @param sourceList
    */
   public AtomicReferenceLinkedList(List<E> sourceList) {
      _head = copy(sourceList);
      SENTINEL_VALUE = new ListItem<>(null, _head.get());
      // _size = new AtomicInteger(sourceList.size());
   }

   /**
    * Creates an instance of AtomicReferenceLinkedList containing all items
    * contained in sourceAtomicList argument
    *
    * @param sourceAtomicList
    */
   public AtomicReferenceLinkedList(AtomicReferenceLinkedList<E> sourceAtomicList) {
      _head = copy(sourceAtomicList);
      SENTINEL_VALUE = new ListItem<>(null, _head.get());
      // _size = new AtomicInteger(sourceAtomicList.size());
   }

   /**
    * Atomically adds value parameter in the list of items.
    *
    * @param value
    * @throws IllegalStateException
    *            in case {@link #shutdown()} was called earlier by some thread
    */
   public void add(final E value) {
      boolean success = false;
      while (!success) {
         ListItem<E> currentHead = _head.get();
         checkIfShutdowned();
         ListItem<E> newHead = new ListItem<>(value, currentHead);
         success = _head.compareAndSet(currentHead, newHead);
      }
      // _size.getAndIncrement();
   }

   /**
    * Shutdowns current list. After this method is called by some thread, all
    * other threads will receive <code>IllegalStateException</code> when call
    * {@link #add(E)}, or {@link #shutdown()}
    *
    * @throws IllegalStateException
    *            in case @{link {@link #shutdown()}} was called earlier by some
    *            thread
    */
   public void shutdown() {
      checkIfShutdowned();
      boolean success = false;
      while (!success) {
         final ListItem<E> currentHead = _head.get();
         final ListItem<E> newHead = SENTINEL_VALUE;
         success = _head.compareAndSet(currentHead, newHead);
      }
   }

   /**
    * Check if value argument is contained in the list.
    *
    * @param value
    *           The object to be checked if contained.
    * @return true if value argument if found in the list and false otherwise
    */
   public boolean contains(final E value) {
      for (E elemValue : this) {
         if (value.equals(elemValue)) {
            return true;
         }
      }
      return false;
   }

   /**
    * @return Returns <code>true</code> in case list contains at least one item,
    *         or false if no items are added to the list.
    */
   public boolean isEmpty() {
      ListItem<E> currentHead = _head.get();
      return currentHead == null
            || (currentHead == SENTINEL_VALUE && currentHead._next == null);
   }

   // /**
   // * @return The number of items in the list.
   // */
   // public int size() {
   // return _size.get();
   // }

   /*
    * (non-Javadoc)
    *
    * @see java.lang.Iterable#iterator()
    */
   @Override
   public Iterator<E> iterator() {
      return new AtomicReferencesIterator();
   }

   private void checkIfShutdowned() {
      if (isShutDown()) {
         throw new IllegalStateException(
               "Forbidden to add to list when list is shutdowned");
      }
   }

   private boolean isShutDown() {
      return (_head.get() == SENTINEL_VALUE);
   }

   private AtomicReference<ListItem<E>> copy(Iterable<E> sourceList) {
      ListItem<E> lastElem = null;
      for (E item : sourceList) {
         ListItem<E> listItem = new ListItem<>(item, lastElem);
         lastElem = listItem;
      }
      return new AtomicReference<>(lastElem);
   }

   /**
    * Represents a node in the list
    *
    * @author vpeevski
    *
    * @param <E>
    */
   private static class ListItem<E> {
      private final E _value;
      private final ListItem<E> _next;

      public ListItem(E value, ListItem<E> next) {
         _value = value;
         _next = next;
      }

      /*
       * (non-Javadoc)
       *
       * @see java.lang.Object#toString()
       */
      @Override
      public String toString() {
         return "[Value: " + (_value == null ? "null" : _value) + ", Next: "
               + (_next != null ? _next._value == null ? "null" : _next._value : "null")
               + "]";
      }
   }

   /**
    * Iterator does not support remove operation. Trying to call remove will
    * throw UnsupportedOperationException.
    *
    * @author vpeevski
    *
    */
   private class AtomicReferencesIterator implements Iterator<E> {

      private ListItem<E> cursor;

      public AtomicReferencesIterator() {
         ListItem<E> initialCursor = _head.get();
         if (isShutDown()) {
            initialCursor = initialCursor._next;
         }
         cursor = initialCursor;
      }

      /*
       * (non-Javadoc)
       *
       * @see java.util.Iterator#hasNext()
       */
      @Override
      public boolean hasNext() {
         return cursor != null;
      }

      /*
       * (non-Javadoc)
       *
       * @see java.util.Iterator#next()
       */
      @Override
      public E next() {
         if (cursor != null) {
            E next = cursor._value;
            cursor = cursor._next;
            return next;
         } else {
            throw new NoSuchElementException();
         }
      }

   }
}
