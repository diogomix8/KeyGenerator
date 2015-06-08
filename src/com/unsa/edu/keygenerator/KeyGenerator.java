/**
 * 
 */
package com.unsa.edu.keygenerator;

/**
 * @author Digeo Fabian Palacio
 * @version 1.0 (22/07/14)
 *
 */
public class KeyGenerator {
	
	/* Atributos */
	public String numbers = "0123456789";
	public String lower_case = "abcdefghijklmnopqrstvuyxwz";
	public String up_case = "ABCDEFGHIJKLMNOPQRSTVUYXWZ";	
	public String special_characters = "@!#$%&=?¿*+-_<>";
	
	/* Metodos */
	
	/**
	 * @return the numbers La cadena de Números.
	 */
	public String getNumbers() {
		return numbers;
	}
	
	/**
	 * @return the lower_case La cadena de Letras Minúsculas.
	 */
	public String getLower_case() {
		return lower_case;
	}
	
	/**
	 * @return the up_case La cadena de Letras Mayúsculas.
	 */
	public String getUp_case() {
		return up_case;
	}
	
	/**
	 * @return the special_characters La cadena de Caracteres Especiales.
	 */
	public String getSpecial_characters() {
		return special_characters;
	}
	
	/**
	 * Genera una clave a partir de una cadena de letras, números, etc. Para ello
	 * hace un random para insertar cada letra en la clave nueva.
	 * @param key Cadena de números, letras, ect.
	 * @param length Longuitud de la clave deseada.
	 * @return pswd La nueva clave creada.
	 */
	public static String GeneratorPassword(String key, int length) {
		String pswd = "";
		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}
		return pswd;
	}
}
