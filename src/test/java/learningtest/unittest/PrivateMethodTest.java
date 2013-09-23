package learningtest.unittest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.izeye.playground.common.util.ReflectionUtils;

public class PrivateMethodTest {

	@Test
	public void testPrivateMethod() {
		String name = "Johnny";
		String expected = "Hi, " + name + ".";

		Greeting greeting = new Greeting();
		// assertThat(greeting.greetInternal(name), is(expected));
		assertThat(ReflectionUtils.invokeMethod(greeting, "greetInternal",
				String.class, name), is(expected));
	}

}

class Greeting {

	private static final String DECORATOR = "*";

	private String greetInternal(String name) {
		return "Hi, " + name + ".";
	}

	public String greet(String name) {
		return DECORATOR + greetInternal(name) + DECORATOR;
	}

}
