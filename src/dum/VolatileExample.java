package dum;

public class VolatileExample {

	private static int MY_INT = 0;

	private static Object _lock = new Object();

	public static void main(String[] args) {
		Thread changeListener = new ChangeListener();
		Thread changeMaker = new ChangeMaker();
		changeListener.start();
		changeMaker.start();
		try {
			changeListener.join();
			changeMaker.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static class ChangeListener extends Thread {
		@Override
		public void run() {
			synchronized (_lock) {
				int local_value = MY_INT;
				while (local_value < 5) {
					if (local_value != MY_INT) {
						System.out.println("Got Change for MY_INT : " + MY_INT);
						local_value = MY_INT;
					} else {
						try {
							_lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}
	}

	static class ChangeMaker extends Thread {
		@Override
		public void run() {

			int local_value = MY_INT;
			synchronized (_lock) {
				while (MY_INT < 5) {
					System.out.println("Incrementing MY_INT to "
							+ (local_value + 1));
					MY_INT = ++local_value;
					_lock.notifyAll();
					// try {
					// Thread.sleep(500);
					// } catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}
	}
}
