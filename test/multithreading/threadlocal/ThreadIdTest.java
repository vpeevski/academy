package multithreading.threadlocal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import multithreading.AsyncTesterPool;

public class ThreadIdTest {

	@Test
	public void testGettingThreadIdShouldProvideNotChangeableUniqueIdForEachThread() throws InterruptedException {
		TestIdRunnable runnable = new TestIdRunnable();
		AsyncTesterPool.createTester(runnable);
		AsyncTesterPool.createTester(runnable);
		AsyncTesterPool.createTester(runnable);
		AsyncTesterPool.createTester(runnable);
		AsyncTesterPool.createTester(runnable);
		AsyncTesterPool.createTester(runnable);
		AsyncTesterPool.startAll();
		AsyncTesterPool.testAll();

		assertEquals(ThreadId.get(), AsyncTesterPool.size());
		assertEquals(ThreadId.get(), AsyncTesterPool.size());
		assertEquals(ThreadId.get(), AsyncTesterPool.size());
	}

	private class TestIdRunnable implements Runnable {

		@Override
		public void run() {
			assertEquals(ThreadId.get(), ThreadId.get());
		}
	}
}
