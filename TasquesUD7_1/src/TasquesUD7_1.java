
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Víctor Lozano
 *
 */
public class TasquesUD7_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String alumnos = JOptionPane.showInputDialog("Cuantos alumnos hay?");
		String notas = JOptionPane.showInputDialog("Cuantas notas tienen los alumnos?");

		int alumnosTotal = Integer.parseInt(alumnos);
		int notasTotal = Integer.parseInt(notas);

		Hashtable<String, Double> mediaFinal = new Hashtable<String, Double>(); // Aqui se almacenan las notas medias
																				// con el nombre

		String nombres[] = new String[alumnosTotal];
		double media[] = new double[notasTotal];

		rellenarNombres(nombres);
		for (int i = 0; i < nombres.length; i++) {
			rellenarNotas(media, i);
			creaDiccionario(nombres, media, mediaFinal, i);
		}
		imprimirHashtable(mediaFinal);

	}

	/**
	 * @param mediaFinal
	 */
	private static void imprimirHashtable(Hashtable<String, Double> mediaFinal) {
		Enumeration<Double> enumeration = mediaFinal.elements();
		Enumeration<String> keys = mediaFinal.keys();
		while (enumeration.hasMoreElements()) {
			System.out.println(keys.nextElement() + " tiene de media un " + enumeration.nextElement());
		}

	}

	/**
	 * @param nombres
	 * @param media
	 * @param mediaFinal
	 * @param i
	 */
	private static void creaDiccionario(String[] nombres, double[] media, Hashtable<String, Double> mediaFinal, int i) {
		double aux = 0;
		for (int j = 0; j < media.length; j++) {
			aux = aux + media[j];
		}
		aux = aux / media.length;
		mediaFinal.put(nombres[i], aux);
	}

	/**
	 * @param media
	 * @param i2
	 */
	private static void rellenarNotas(double[] media, int i2) {
		for (int i = 0; i < media.length; i++) {
			String notas = JOptionPane.showInputDialog("Notas del alumno" + i2);
			media[i] = Double.parseDouble(notas);
		}

	}

	/**
	 * @param nombres
	 */
	private static void rellenarNombres(String[] nombres) {
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = JOptionPane.showInputDialog("Nombre del alumno " + i);
		}

	}

}
