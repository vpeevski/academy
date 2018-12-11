package multithreading.threadlocal.generator.random;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RangeRandomGeneratorTest {

	@Test
	public void test() throws InterruptedException {
		Integer _generatedValue1 = new RangeRandomGenerator(1, 10).generate();
		System.out.println(_generatedValue1);
		Integer _generatedValue2 = new RangeRandomGenerator(11, 20).generate();
		System.out.println(_generatedValue2);
		Integer _generatedValue3 = new RangeRandomGenerator(21, 30).generate();
		System.out.println(_generatedValue3);

		assertThat(_generatedValue1, allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(10)));
		assertThat(_generatedValue2, allOf(greaterThanOrEqualTo(11), lessThanOrEqualTo(20)));
		assertThat(_generatedValue3, allOf(greaterThanOrEqualTo(21), lessThanOrEqualTo(30)));
	}

}
