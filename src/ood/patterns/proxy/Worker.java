package ood.patterns.proxy;

public class Worker implements Work {

	@Override
	public boolean doSomething() {
		System.out.println("Do some job");
		return true;
	}

}
