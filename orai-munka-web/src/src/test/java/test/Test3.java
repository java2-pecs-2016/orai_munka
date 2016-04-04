package test;

import hu.sol.mik.unittest.core.Main;
import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class Test3 {

	@Test
	public void test() {
		Assert.assertEquals(Main.getMainModel().getAssert1(), "true");
		Assert.assertEquals(Main.getMainModel().getAssert2(), "true");
		Assert.assertNotNull(Main.getMainModel());
		Assert.assertNotSame(Main.getMainModel().getAssert1(), "false");
	}

}
