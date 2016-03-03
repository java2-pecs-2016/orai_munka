package test;

import hu.sol.mik.unittest.core.Main;
import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class Test2 {

	@Test
	public void testPrintHelloWorld2() {
		Assert.assertEquals(Main.getHelloWorld2(), "Hello World 2");
	}

}
