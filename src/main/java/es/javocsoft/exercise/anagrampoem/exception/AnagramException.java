package es.javocsoft.exercise.anagrampoem.exception;

/**
 * Anagram Checker exception.
 * 
 * @author Javier Gonzalez Serrano
 * @since Dec, 2014
 * @version 1.0.0
 *
 */
@SuppressWarnings("serial")
public class AnagramException extends Exception {

	public AnagramException() {
		super();
	}

	public AnagramException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);		
	}

	public AnagramException(String message, Throwable cause) {
		super(message, cause);		
	}

	public AnagramException(String message) {
		super(message);		
	}

	public AnagramException(Throwable cause) {
		super(cause);		
	}
	
}
