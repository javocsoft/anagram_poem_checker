package es.javocsoft.tests.onebox;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

/**
 * Anagram checker.
 * 
 * First: 	Clean text and get lines
 * Second:	Check lines
 * 
 * There is a good Set type that is ideal for this 
 * purpose, is called Multiset, from Google GUAVA 
 * linrary. I use this for character count and index.
 * See 
 * 	https://code.google.com/p/guava-libraries/
 * 
 * I only need one class, this, no need of more 
 * complexity :)
 * 
 * @author Javier Gonzalez Serrano
 * @since Dec, 2014
 * @version 1.0.0
 * 
 */
public class AnagramChecker {
	
	private static Logger logger = Logger.getLogger(AnagramChecker.class);
	
	//To avoid instances
	private AnagramChecker() { }
	
	
	
	/**
	 * Checks if a text is an anagram or not.
	 * 
	 * @param text
	 */
	public static boolean isAnagram(String text) {
		boolean res = false;
		
		logger.info("\n"+text+"\n");
		
		List<String> normalizedLines = new ArrayList<String>();
		if(firstStep(text, normalizedLines)){
			if(secondStep(normalizedLines)){
				logger.info("RESULT: It is an Anagram poem :)");
				res = true;
			}else{
				logger.info("RESULT: It is NOT an Anagram poem :(");
			}
		}else{
			logger.info("RESULT: It is NOT an Anagram poem :(");
		}
		
		return res;
	}
	
	
	
	//AUXILIAR
	
	/**
	 * First pass - Normalizes lines and checks line lengths
	 * 
	 * @param text
	 * @param normalizedLines
	 * @return TRUE if the first step is OK, otherwise FALSE.
	 */
	private static boolean firstStep(String text, List<String> normalizedLines) {
		boolean firstPassOk = true;
		String[] lines = text.toLowerCase().split(System.getProperty("line.separator"));
		int letterCounter = 0;
		for(String l:lines){
			//System.out.println(l);
			l = normalize(l);
			if(l!=null && l.length()>0){
				normalizedLines.add(l);
				if(letterCounter!=0){
					if(letterCounter!=l.length()){
						firstPassOk = false;
						break;				
					}
				}
				letterCounter=l.length();
			}
		}
		
		return firstPassOk;
	}
	
	/**
	 * Second pass - Check for possible anagram lines
	 * 
	 * @param linesToCheck
	 * @return TRUE if the second step is OK, otherwise FALSE.
	 */
	private static boolean secondStep(List<String> linesToCheck) {
		boolean secondPass = true;
		
		//Second pass - Check anagram lines
		Multiset<Character> characterCount = null;
		Multiset<Character> characterCountCurrent = null;
		for(String s:linesToCheck){
			characterCountCurrent = getCharactersCount(s);
			if(characterCount!=null){					
				//Compare with previous
				if(!lineIsLineAnagram(characterCountCurrent, characterCount)){
					secondPass = false;
					break;				
				}
			}
			characterCount = characterCountCurrent;				
		}
		
		return secondPass;
	}
	
	/**
	 * Gets a GUAVA Multiset from the specified text. 
	 * This gives a counter of letters in a simple 
	 * and easy usable way.
	 * 
	 * See 	https://code.google.com/p/guava-libraries/
	 * 		https://google-collections.googlecode.com/svn/trunk/javadoc/com/google/common/collect/Multiset.html
	 * 
	 * @param line
	 * @return
	 */
	private static Multiset<Character> getCharactersCount(String line) {
		Multiset<Character> characterCount = HashMultiset.create();
		for (char c: line.toCharArray()) {
		    characterCount.add(c);
		}
		
		return characterCount;
	}
	
	/**
	 * Compares the content of two lines to see if both have the
	 * same letters and times a letter appears on that line.
	 * 
	 * @param lineCharactersCount
	 * @param lineCharactersCountCompareWith
	 * @return
	 */
	private static boolean lineIsLineAnagram(Multiset<Character> lineCharactersCount, Multiset<Character> lineCharactersCountCompareWith) {
		boolean res = true;
		
		for (Entry<Character> entry: lineCharactersCount.entrySet()) {
			boolean found = false;
		    for (Entry<Character> entryC: lineCharactersCountCompareWith.entrySet()) {
		    	if(entry.getElement()==entryC.getElement() &&
		    		entry.getCount()==entryC.getCount()){
		    		found=true;
		    		break;
		    	}		    	
		    }
		    
		    if(!found){
		    	res = false;
		    	break;
		    }
		}
				
		return res;
	}
	
	/**
	 * Normalizes a text:
	 * 
	 * 	- Removing all non character/numbers
	 * 	- Getting the non accented versions of the letters.
	 * 
	 * @param text
	 * @return	The normalized text.
	 */
	private static String normalize(String text) {
		//This regular expression matches all (Unicode) characters 
		//that are neither letters nor (decimal) digits
		String result = text.replaceAll("[^\\p{L}\\p{Nd}]+", "");
		
		//Now we normalize the text according to NFD.
		//This will do a "Canonical decomposition":
		//	This will separate all of the accent marks from the characters. 
		//	Then, you just need to compare each character against being a 
		//	letter and throw out the ones that aren't :)
		//See
		//	https://docs.oracle.com/javase/tutorial/i18n/text/normalizerapi.html
		result = Normalizer.normalize(result, Normalizer.Form.NFD);
		//	For unicode, \\P{M} matches the base glyph and
		//  \\p{M} (lowercase) matches each accent.
		result = result.replaceAll("\\p{M}", "");
		
		//Now the line is totally clean :D
		//System.out.println(result + "\n");
		
		return result;
	}
}
