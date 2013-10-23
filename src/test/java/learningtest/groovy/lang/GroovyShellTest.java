package learningtest.groovy.lang;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import org.junit.Test;

public class GroovyShellTest {

	@Test
	public void evaluate() {
		Binding binding = new Binding();
		binding.setVariable("foo", new Integer(2));
		GroovyShell shell = new GroovyShell(binding);

		Object value = shell
				.evaluate("println 'Hello World!'; x = 123; return foo * 10");
		assert value.equals(new Integer(20));
		assert binding.getVariable("x").equals(new Integer(123));
	}

}
