package multithreading.threadlocal;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author User
 *
 */
public final class ThreadId {

	private static final AtomicInteger _id = new AtomicInteger(0);

	private static final ThreadLocal<Integer> _threadId = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return _id.getAndIncrement();
		}
	};

	private ThreadId() {
	}

	public static int get() {
		return _threadId.get();
	}
}
