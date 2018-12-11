package multithreading.threadlocal.generator.random;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import sun.security.jca.GetInstance;

public class RangeRandomGenerator {

	private final AtomicInteger _min;

	private final AtomicInteger _max;

	private static GeneratorRunnable<Integer> _generatorRunnable;

	private final ExecutorService executorService;

	public RangeRandomGenerator(Integer min, Integer max) {
		_min = new AtomicInteger(min);
		_max = new AtomicInteger(max);
		_generatorRunnable = new GeneratorRunnable<>(this);
		executorService = Executors.newCachedThreadPool();
	}

	public Integer generate() {
		FutureTask<Integer> randomInFuture = new FutureTask<Integer>(_generatorRunnable);
		executorService.execute(randomInFuture);

		try {
			Integer result = randomInFuture.get();
			return result;
		} catch (InterruptedException | ExecutionException e) {
			throw new IllegalStateException("Random generarion interrupted !");
		}

	}

	private static class GeneratorRunnable<T> implements Callable<Integer> {

		// private ThreadLocal<Integer> _randomValue = new ThreadLocal<>();

		private AtomicInteger _randomValue = new AtomicInteger();

		private final RangeRandomGenerator rangeRandomGenerator;

		public GeneratorRunnable(RangeRandomGenerator rangeRandomGenerator) {
			this.rangeRandomGenerator = rangeRandomGenerator;
		}

		@Override
		public Integer call() throws Exception {
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
				_randomValue.set(this.rangeRandomGenerator._min.get() +
						(int) Math.floor(new Random().nextDouble() *
								(this.rangeRandomGenerator._max.get()
										- this.rangeRandomGenerator._min.get())));
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
				return _randomValue.get();
			} catch (InterruptedException e) {
				throw new IllegalStateException("Generator thread interrupted");
			}
		}
	}

}
