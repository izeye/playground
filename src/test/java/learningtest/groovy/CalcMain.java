package learningtest.groovy;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalcMain {

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("groovy");

		System.out.println(engine.eval("(1..10).sum()"));

		engine.put("first", "HELLO");
		engine.put("second", "world");
		System.out.println(engine
				.eval("first.toLowerCase() + second.toUpperCase()"));
	}

}
