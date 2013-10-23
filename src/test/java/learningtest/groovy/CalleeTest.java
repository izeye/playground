package learningtest.groovy;

import org.junit.Test;

import test.Callee;
import test.CalleeAnother;

public class CalleeTest {

	@Test
	public void test() {
		Callee callee = new Callee();
		callee.hello();

		CalleeAnother calleeAnother = new CalleeAnother();
		calleeAnother.hello();
	}

}
