package es.javocsoft.tests.exercise.anagrampoem;

import java.io.File;
import java.io.InputStream;

import es.javocsoft.exercise.anagrampoem.AnagramChecker;
import es.javocsoft.exercise.anagrampoem.exception.AnagramException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Anagram Poem tool.
 */
public class AppTest extends TestCase {
	
	String anagram_1_ok = "¿Bruta concesión o\n"
			+ " un narcótico beso?\n"
			+ "Cuantioso bronce, \n" +
			 "Tesoro, concubina \n" +
			 "Obtención oscura \n" +
			 "En consorcio tabú, \n" + 
			 "En botánico surco.\n" +
			"¡Cabrones! ¡Un coito!";		
	
	String anagram_2_fail = "Tal gema hormonal \n" 
			+ "¡Container azur! \n"
			+ "Tal hermana mogol \n"
			+ "¿Nunca erotizar?";
	
	String anagram_3_ok = "Centígrada nación\n"+ 
			"E intrincada conga \n"+
			"¡Da cinco Argentina! \n"+
			"Gana con indirecta \n"+
			"Tan digna creación \n"+
			"\n" +
			"Ante gran adicción\n"+ 
			"Arte, canción digna \n"+
			"canción integrada \n"+
			"Gira cinta condena. ";
	
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	
	/** Tests */
	
	public void testAnagram1_OK() {	
		try{
			assertTrue(AnagramChecker.isAnagram(anagram_1_ok, false));
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
	}
	
	public void testAnagram2_NOT_OK() {
		try{
			assertFalse(AnagramChecker.isAnagram(anagram_2_fail, false));
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
	}
	
	public void testAnagram3_OK() {
		try{
			assertTrue(AnagramChecker.isAnagram(anagram_3_ok, false));
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
	}
	
	public void testAnagram4_fromFile_NOT_OK() {
		try{
			ClassLoader classLoader = getClass().getClassLoader();
		    File file = new File(classLoader.getResource("anagram_file_1.txt").getFile());
		    
			assertFalse(AnagramChecker.isAnagram(file.getAbsolutePath(), true));
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
	}
	
	public void testAnagram4_fromFile_OK() {
		try{
			ClassLoader classLoader = getClass().getClassLoader();
		    File file = new File(classLoader.getResource("anagram_file_2.txt").getFile());
		    
			assertTrue(AnagramChecker.isAnagram(file.getAbsolutePath(), true));
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
	}
	
}
