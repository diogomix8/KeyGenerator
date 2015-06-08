/**
 * Clase para poder validar los datos ingresados por el usuario
 * para que estos sean correctos a la hora de ejecutar o se este
 * ejecutando el programa.
 */
package com.unsa.edu.keygenerator;

/**
 * @author Digeo Fabian Palacio
 * @version 1.0 (22/07/14)	
 */
public class ValidateData {
	/* Atributos */
	/* Representa a la longuitud m�xima de la clave a crear y que usuario puede ingresar */
	public static final int LENGTH_MAX = 20;
	
	/* M�todos */
	/**
	 * A partir de un String que obtenemos del campo TextField, vamos a validar si este tiene
	 * un campo vacio o no, para luego poder enviar un mensaje al usuario.
	 * @param text_fields	Par�metro recib�do del campo a verificar.
	 * @return	Un mensaje en blanco si los datos son correctos y sino un mensaje de error.
	 */
	public String EmptyFields(String text_fields) {
		/* Inicializamos la cadena que contendra el resultado */
		String msj_result = "";
		if (text_fields.equals("")) {/* Si el campo esta vaci� */
			msj_result += "Por Favor, Ingrese un N�mero.";
		}	
		return msj_result;
	}
	/**
	 * Verifica si el n�mero ingresado no sobrepasa el l�mite establecido para la longuitud de 
	 * la clave a crear.
	 * @param limit	N�mero ingresado por el usuario.
	 * @return	True si no sobrepasa el l�mite o False si lo hace.
	 */
	public boolean LimitLength(int limit) {
		/* Inicializamos al bandera en false porque el campo aun no fue validado */
		boolean flag_limit = false;
		/* Si el n�mero ingresado es menor o igual que el l�mite permitido, entonces
		 * cambiamos la bandera a "true", sino la dejamos en "false". */
		if (limit <= LENGTH_MAX) {
			flag_limit = true;
		}
		return flag_limit;
	}
	

}
