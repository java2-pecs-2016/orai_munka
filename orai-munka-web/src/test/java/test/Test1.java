package test;

import hu.sol.mik.unittest.core.Main;
import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class Test1 {

	@Test
	public void testPrintHelloWorld() {
		Assert.assertEquals(Main.getHelloWorld(), "Hello World");
	}

}
