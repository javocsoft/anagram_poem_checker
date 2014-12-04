package es.javocsoft.tests.onebox;

/**
 * Anagram checker.
 * 
 * An Anagram Poem is just only a set of lines with:
 * 
 * 	- Same length (excluding non letter/number characters)
 *  - Same content (characters) and number of apparitions
 *    of each one (order is different).
 * 
 * I use UNICODE for text manipulations.
 * 
 * @author Javier Gonzalez Serrano
 * @since Dec, 2014
 * @version 1.0.0
 */
public class App 
{
    public static void main( String[] args )
    {
    	String anagram_1 = "¿Bruta concesión o\n"
				+ " un narcótico beso?\n"
				+ "Cuantioso bronce, \n" +
				 "Tesoro, concubina \n" +
				 "Obtención oscura \n" +
				 "En consorcio tabú, \n" + 
				 "En botánico surco.\n" +
				"¡Cabrones! ¡Un coito!";		
		
		String anagram_2 = "Tal gema hormonal \n" 
				+ "¡Container azur! \n"
				+ "Tal hermana mogol \n"
				+ "¿Nunca erotizar?";
		
		String anagram_3 = "Centígrada nación\n"+ 
				"E intrincada conga \n"+
				"¡Da cinco Argentina! \n"+
				"Gana con indirecta \n"+
				"Tan digna creación \n"+
				"\n" +
				"Ante gran adicción\n"+ 
				"Arte, canción digna \n"+
				"canción integrada \n"+
				"Gira cinta condena. ";
		
		System.out.println("--------------------------------------------------------");
		AnagramChecker.isAnagram(anagram_1);				
		System.out.println("--------------------------------------------------------\n");
		System.out.println("--------------------------------------------------------");
		AnagramChecker.isAnagram(anagram_2);
		System.out.println("--------------------------------------------------------\n");
		System.out.println("--------------------------------------------------------");
		AnagramChecker.isAnagram(anagram_3);
		System.out.println("--------------------------------------------------------");
	}
    
}
