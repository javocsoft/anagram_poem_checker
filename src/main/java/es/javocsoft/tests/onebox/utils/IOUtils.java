package es.javocsoft.tests.onebox.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import es.javocsoft.tests.onebox.exception.AnagramException;

/**
 * Class for IO auxiliar functions.
 * 
 * @author Javier Gonzalez Serrano
 * @since Dec, 2014
 * @version 1.0.0
 *
 */
public class IOUtils {

	
	/**
	 * Reads a text anagram file.
	 * 
	 * @param file
	 * @return
	 * @throws AnagramException
	 */
	public static String readTextFile(String file) throws AnagramException {
		String text = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				text = sb.toString();
			} finally {
				try{
					br.close();
				}catch(Exception e){ }
			}

		} catch (FileNotFoundException e) {
			throw new AnagramException("File does not exists.", e);
		} catch (IOException e) {
			throw new AnagramException("Error reading file '" + file + "', error [" + e.getMessage() + "].", e);
		}

		return text;
	}
}
