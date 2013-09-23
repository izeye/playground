package learningtest.object.init;

import org.junit.Test;

public class InitializationTest {

	@Test
	public void test() {
		new A();
	}

	private class A {
		private String string = "string";
		{
			string = "string2";
		}

		public A() {
			System.out.println(string);
		}
	}

}
