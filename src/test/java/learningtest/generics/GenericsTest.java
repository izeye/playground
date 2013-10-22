package learningtest.generics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GenericsTest {

	@Test
	public void test() {
		List<A> aList = new ArrayList<A>();
		doSomethingWithGenercis(aList);
		doSomethingWithWildcard(aList);

		List<B> bList = new ArrayList<B>();
		doSomethingWithGenercis(bList);
		doSomethingWithWildcard(bList);

		List<C> cList = new ArrayList<C>();
		// doSomethingWithGenercis(cList); // Doesn't work.
		// doSomethingWithWildcard(cList); // Doesn't work.
	}

	public <T extends A> void doSomethingWithGenercis(List<T> list) {
	}

	public void doSomethingWithWildcard(List<? extends A> list) {
	}

	class A {

	}

	class B extends A {

	}

	class C {

	}

}
