package test

import org.junit.Test

class CalleeTest {

	@Test
	public void test() {
		def c = new Callee()
		c.hello()

		def cAnother = new CalleeAnother()
		cAnother.hello()
	}
}
