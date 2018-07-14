package multithreading;

public class AsyncTester {

	private final Thread _t;

	private AssertionError _error;

	public AsyncTester(final Runnable runnable) {
		_t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runnable.run();
				} catch (AssertionError e) {
					_error = e;
				}

			}
		});
	}

	public final AsyncTester start() {
		_t.start();
		return this;
	}

	public final void test() throws InterruptedException {
		_t.join();
		if (_error != null) {
			System.err.println(_error);
			throw _error;
		}
	}

}
