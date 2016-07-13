package ood.ptterns.proxy;

import static org.junit.Assert.*;
import ood.patterns.proxy.Work;
import ood.patterns.proxy.Worker;
import ood.patterns.proxy.WorkerClient;
import ood.patterns.proxy.WorkerProxy;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void testWorker () {
		Work worker = new Worker();
		assertTrue(worker.doSomething());
	}
	
	@Test
	public void testWorkerProxy () {
		Work worker = new Worker();
		Work workerProxy = new WorkerProxy(worker);
		assertTrue(workerProxy.doSomething());
	}
	
	@Test
	public void testClientNullWorker () {
		WorkerClient client = new WorkerClient();
		try {
			client.askForWork(null);
			fail("NPE expected");
		} catch (NullPointerException npe) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testClientNullWorkerProxy () {
		WorkerClient client = new WorkerClient();
		Work workerProxy = new WorkerProxy(null);
		assertFalse(client.askForWork(workerProxy));
	}
	
	

}
