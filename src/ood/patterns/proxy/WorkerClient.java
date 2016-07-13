package ood.patterns.proxy;

public class WorkerClient {
	
	public boolean askForWork (Work worker) {
		return worker.doSomething();
	}

}
