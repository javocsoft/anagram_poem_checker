package es.javocsoft.exercise.anagrampoem;

import es.javocsoft.exercise.anagrampoem.exception.AnagramException;

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
		
		String anagram_4 = "Tanto aquí como en Roma el amor en un ramo mora\n"+
		"y el que mala tiene el alma que la tristeza lama\n"+
		"quien orada con el arado el corazón ,adora\n"+
		"no necesita arma quien ama cual ave a su rama\n"+
		"\n" +
		"quien va a osar con el dedo raso rosar una rosa\n"+
		"necesita el valor de un ave para poder volar\n"+
		"hecho una sopa en la lluvia al paso solo se posa\n"+
		"se seca con fuego y mirra y se detiene a rimar\n"+
		"\n" +
		"curalo si dice que quiere ocultar su locura \n"+
		"recuerda educar con una cuerda si es necesario\n"+
		"mas no hay que abusar el despecho tira a la basura\n"+
		"y no compres en la licorería un relicario\n";
		
		
		
		System.out.println("--------------------------------------------------------");
		try {
			AnagramChecker.isAnagram(anagram_1, false);
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
		System.out.println("--------------------------------------------------------\n");
		System.out.println("--------------------------------------------------------");
		try{
			AnagramChecker.isAnagram(anagram_2, false);
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
		System.out.println("--------------------------------------------------------\n");
		System.out.println("--------------------------------------------------------");
		try {
			AnagramChecker.isAnagram(anagram_3, false);
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		try{
			AnagramChecker.isAnagram(anagram_4, false);
		} catch (AnagramException e) {
			System.out.println("Error checking anagram: " + e.getMessage());
		}				
		System.out.println("--------------------------------------------------------");
					
	}
    
}
