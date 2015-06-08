/**
 * 
 */
package com.unsa.edu.keygenerator.windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/* Importamos el paquete que contiene los métodos con los cuales vamos a trabajar
 * para poder crear la clave. */
import com.unsa.edu.keygenerator.*;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


/**
 * @author Digeo Fabian Palacio
 */
public class MainWindows {

	private JFrame frmKeyGeneratorMain;
	private JTextField textField_ViewKey;
	private JTextField textField_LengthKey;
	/* Instanciamos un Objeto de la Clase KeyGenerator para llamar a los Métodos.*/
	KeyGenerator NewKey = new KeyGenerator();
	/* Instanciamos otro Objeto de la Clase ValidateData para poder validar los datos ingresados */
	ValidateData ValData = new ValidateData();
	/* Creamos un atributo global para poder asignarlo, una vez completado el proceso,la clave temporal.  */
	private String temp_key = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows window = new MainWindows();
					window.frmKeyGeneratorMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKeyGeneratorMain = new JFrame();
		frmKeyGeneratorMain.setResizable(false);
		frmKeyGeneratorMain.setTitle("Genedor de Claves");
		frmKeyGeneratorMain.setBounds(100, 100, 599, 266);
		frmKeyGeneratorMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKeyGeneratorMain.getContentPane().setLayout(null);
		
		/** 
		 * Al presionar el Boton "Crear Clave", vamos a generar una clave de una
		 * cierta longuitud definida anteriomente por el usuario que sera visualizada 
		 * por el TextField_ViewKey.
		 */
		JButton btnCreateKey = new JButton("Crear Clave");
		btnCreateKey.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreateKey.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				/* Validamos primero si el campo de texto no esta vacio. Para ellos si EmptyFields devuelve
				 * una cadena vacia "" , hay datos en el campo. */
				
				if (ValData.EmptyFields(textField_LengthKey.getText()) != ""){
					JOptionPane.showMessageDialog(null, "ERROR!! \n " + ValData.EmptyFields(textField_LengthKey.getText()), "Validando datos", JOptionPane.WARNING_MESSAGE);
				}
				/* Ahora validamos el límite para la lomguitud de la clave, tomando lo que hay en el campo de texto */
				int length_new = Integer.parseInt(textField_LengthKey.getText());
				if (ValData.LimitLength(length_new) == true ) {
					String receives_key = NewKey.GeneratorPassword(temp_key, length_new);
					/* Mostramos la clave creada en el campo de texto de la ventana principal */
					textField_ViewKey.setText(receives_key);
				}
				else {
					JOptionPane.showMessageDialog(null, "Ingrese un Número del 1 al 20");
				}
				
			}
		});
		
		/**
		 *  Agregamos el Boton "Crear Clave" a la Ventana Principal de este Frame"
		 */
		btnCreateKey.setBounds(11, 192, 104, 23);
		frmKeyGeneratorMain.getContentPane().add(btnCreateKey);
		
		/**
		 *  Agregamos el TextField_ViewKey, que mostrara al usuario la clave creada aleatoriamente. 
		 */
		textField_ViewKey = new JTextField();
		textField_ViewKey.setBounds(124, 193, 449, 20);
		frmKeyGeneratorMain.getContentPane().add(textField_ViewKey);
		textField_ViewKey.setColumns(10);
		
		/**
		 * Agregamos un Panel que contendra las opciones del Programa.
		 */
		JPanel panelOptions = new JPanel();
		panelOptions.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOptions.setBounds(11, 11, 562, 170);
		frmKeyGeneratorMain.getContentPane().add(panelOptions);
		panelOptions.setLayout(null);
		
		/**
		 * Una Etiqueta para hacer referencia a la Longuitud.
		 */
		JLabel lblLonguitud = new JLabel("Longuitud");
		lblLonguitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLonguitud.setBounds(10, 25, 58, 14);
		panelOptions.add(lblLonguitud);
		
		/**
		 * Un TextField para que podamos tomar la longuitud (en números), que el usuario
		 * desee para poder crear luego la clave aleatoria.
		 */
		textField_LengthKey = new JTextField();
		textField_LengthKey.setBounds(71, 22, 102, 20);
		panelOptions.add(textField_LengthKey);
		textField_LengthKey.setColumns(10);
		
		/* Límite para la Longuitud de la clave a crear. */
		JLabel lblMax = new JLabel("(M\u00E1ximo 20)");
		lblMax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMax.setBounds(183, 25, 109, 14);
		panelOptions.add(lblMax);
		
		/* CheckBox para los números de 0 al 9 
		 * Cuando este sea seleccionado lo vamos a ir agregando a la clave temporal. */
		JCheckBox chckbxNumbers = new JCheckBox("N\u00FAmeros   (ej. 0,1,2,...,9)");
		chckbxNumbers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNumbers.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e1) {
				if (chckbxNumbers.isSelected()==true) {
					/* Concatenamos con lo que ya tenía la posible clave temporal. */
					temp_key = temp_key + NewKey.getNumbers();
				}
				
			}
		});
		chckbxNumbers.setBounds(6, 56, 286, 23);
		panelOptions.add(chckbxNumbers);
		
		/* CheckBox para las letras minúsculas desde la "a" hasta la "z" 
		 * Cuando este sea seleccionado lo vamos a ir agregando a la clave temporal. */
		JCheckBox chckbxLowerCase = new JCheckBox("Letras Min\u00FAsculas  (ej. a,b,c,...,z)");
		chckbxLowerCase.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxLowerCase.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e2) {
				if (chckbxLowerCase.isSelected()==true) {
					/* Concatenamos con lo que ya tenía la posible clave temporal. */
					temp_key = temp_key + NewKey.getLower_case(); 
				}
				
			}
		});
		chckbxLowerCase.setBounds(6, 82, 286, 23);
		panelOptions.add(chckbxLowerCase);
		
		/* CheckBox para las letras mayúsculas dede la "A" hasta la "Z" 
		 * Cuando este sea seleccionado lo vamos a ir agregando a la clave temporal. */
		JCheckBox chckbxUpCase = new JCheckBox("Letras May\u00FAsculas  (ej. A,B,C,...,Z)");
		chckbxUpCase.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxUpCase.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e3) {
				if (chckbxUpCase.isSelected()==true) {
					/* Concatenamos con lo que ya tenía la posible clave temporal. */
					temp_key = temp_key + NewKey.getUp_case();
				}
				
			}
		});
		chckbxUpCase.setBounds(6, 111, 286, 23);
		panelOptions.add(chckbxUpCase);
		
		/* CheckBox para los caracteres especiales.
		 * Cuando este sea seleccionado lo vamos a ir agregando a la clave temporal. */
		JCheckBox chckbxSpecialChar = new JCheckBox("Caracteres Especiales  (ej. @,#,&,...,?)");
		chckbxSpecialChar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSpecialChar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e4) {
				if (chckbxSpecialChar.isSelected()==true) {
					/* Concatenamos con lo que ya tenía la posible clave temporal. */
					temp_key = temp_key + NewKey.getSpecial_characters();
				}
				
			}
		});
		chckbxSpecialChar.setBounds(6, 137, 286, 23);
		panelOptions.add(chckbxSpecialChar);
		panelOptions.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblLonguitud, textField_LengthKey, lblMax, chckbxNumbers, chckbxLowerCase, chckbxUpCase, chckbxSpecialChar}));
	}
}
