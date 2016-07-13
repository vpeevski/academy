package ood.patterns.proxy;

public final class WorkerProxy implements Work {
	
	private final Work _worker;
	
	public WorkerProxy (Work worker) {
		_worker = worker;
	}

	@Override
	public boolean doSomething() {

		if (_worker != null) {
			System.out.println("Prepare to work");
			_worker.doSomething();
			System.out.println("Cleanup after working");
			return true;
		} else {
			System.out.println("No worker available");
			return false;
		}
		
	}

}
