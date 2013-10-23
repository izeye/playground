package learningtest.groovy;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class FactMain {

	public static void main(String[] args) throws ScriptException,
			NoSuchMethodException {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("groovy");
		String fact = "def factorial(n) { n == 1 ? 1 : n * factorial(n - 1) }";
		engine.eval(fact);
		Invocable inv = (Invocable) engine;
		Object[] params = { new Integer(5) };
		Object result = inv.invokeFunction("factorial", params);
		System.out.println(result);
	}

}
