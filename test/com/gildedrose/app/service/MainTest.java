/**
 * 
 */
package com.gildedrose.app.service;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author subala
 *
 */
public class MainTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.gildedrose.app.service.Main#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainWithArg() {
		//Get the current project directory and add the input file path
		String[] arg = {System.getProperty("user.dir")+"/test/input.txt"};
		Main.main(arg);
		String expected = "";	
		assertTrue(outContent.toString().startsWith(expected));
		
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.Main#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainWithoutArg() {
		String[] arg = {};
		Main.main(arg);				
		String expected = "Please specify the file name";
		assertTrue(outContent.toString().startsWith(expected));
		
	}
	

}
