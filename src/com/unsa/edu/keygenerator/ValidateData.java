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
	/* Representa a la longuitud máxima de la clave a crear y que usuario puede ingresar */
	public static final int LENGTH_MAX = 20;
	
	/* Métodos */
	/**
	 * A partir de un String que obtenemos del campo TextField, vamos a validar si este tiene
	 * un campo vacio o no, para luego poder enviar un mensaje al usuario.
	 * @param text_fields	Parámetro recibído del campo a verificar.
	 * @return	Un mensaje en blanco si los datos son correctos y sino un mensaje de error.
	 */
	public String EmptyFields(String text_fields) {
		/* Inicializamos la cadena que contendra el resultado */
		String msj_result = "";
		if (text_fields.equals("")) {/* Si el campo esta vació */
			msj_result += "Por Favor, Ingrese un Número.";
		}	
		return msj_result;
	}
	/**
	 * Verifica si el número ingresado no sobrepasa el límite establecido para la longuitud de 
	 * la clave a crear.
	 * @param limit	Número ingresado por el usuario.
	 * @return	True si no sobrepasa el límite o False si lo hace.
	 */
	public boolean LimitLength(int limit) {
		/* Inicializamos al bandera en false porque el campo aun no fue validado */
		boolean flag_limit = false;
		/* Si el número ingresado es menor o igual que el límite permitido, entonces
		 * cambiamos la bandera a "true", sino la dejamos en "false". */
		if (limit <= LENGTH_MAX) {
			flag_limit = true;
		}
		return flag_limit;
	}
	

}
