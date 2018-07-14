package multithreading;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AsyncTesterPool {

	private static final List<AssertionError> _failures = new CopyOnWriteArrayList<>();

	private static final List<AsyncTester> _asyncTesters = new CopyOnWriteArrayList<>();

	public static final AsyncTester createTester(Runnable runnable) {
		AsyncTester asyncTester = new AsyncTester(runnable);
		_asyncTesters.add(asyncTester);
		return asyncTester;
	}

	public static void startAll() {
		for (AsyncTester asyncTester : _asyncTesters) {
			asyncTester.start();
		}

	}

	public static void testAll() throws InterruptedException {
		StringBuilder sb = new StringBuilder();
		for (AsyncTester asyncTester : _asyncTesters) {
			try {
				asyncTester.test();
			} catch (AssertionError e) {
				_failures.add(e);
				sb.append(e.getMessage());
				sb.append("\n");
			}
		}

		if (!_failures.isEmpty()) {
			throw new AssertionError(sb.toString());
		}
	}

	public static int size() {
		return _asyncTesters.size();
	}

}
