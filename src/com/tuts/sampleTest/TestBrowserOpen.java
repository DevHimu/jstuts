package com.tuts.sampleTest;

import org.testng.annotations.Test;

import com.tuts.base.Base;

public class TestBrowserOpen {

	@Test
	public void openBrowserTest()
	{
		new Base().initChromeDriver("https://www.google.com");
	}
}
