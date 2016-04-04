package hu.sol.mik.unittest.model;

public class MainModel {

	private String assert1;

	private String assert2;
	
	public MainModel(String assert1, String assert2) {
		super();
		this.assert1 = assert1;
		this.assert2 = assert2;
	}

	public String getAssert1() {
		return assert1;
	}

	public void setAssert1(String assert1) {
		this.assert1 = assert1;
	}

	public String getAssert2() {
		return assert2;
	}

	public void setAssert2(String assert2) {
		this.assert2 = assert2;
	}

}
