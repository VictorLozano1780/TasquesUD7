import java.util.Hashtable;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Víctor Lozano
 *
 */
public class TasquesUD7_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hashtable<String, Double> database = new Hashtable<>();
		database.put("Macarrones", 0.99);
		database.put("Raviolis", 2.0);
		database.put("Espaguetis", 1.99);
		database.put("Tallarines", 1.99);
		database.put("Fideos", 2.99);
		database.put("Pan", 0.40);
		database.put("Cereales", 3.0);
		database.put("Galletas", 7.0);
		database.put("Turron", 4.5);
		database.put("Cerveza", 7.89);

		Hashtable<String, Double> carrito = new Hashtable<>();
		boolean start = true;

		while (start) {
			String opcion = JOptionPane.showInputDialog(
					"Opciones: 1: Añadir articulo || 2: Cosultar información de 1 producto || 3: Listar todo || Otro: Cerrar app");
			switch (opcion) {
			case "1":
				añadirArticulo(carrito, database);
				break;
			case "2":
				consultarInfo(database);
				break;
			case "3":
				String queQuieres = JOptionPane
						.showInputDialog("Que quieres mostrar? 1: Productos de la tienda || 2: Productos del carro");
				if (queQuieres.equals("1")) {
					listarTodo(database);
				} else {
					listarTodo(carrito);
				}
				break;
			default:
				start = false;
			}
		}

	}

	/**
	 * @param database
	 */
	private static void listarTodo(Hashtable<String, Double> database) {
		for (Entry<String, Double> entry : database.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	/**
	 * @param database
	 */
	private static void consultarInfo(Hashtable<String, Double> database) {
		String producto = JOptionPane.showInputDialog("De que producto quieres información");
		System.out.println(database.get(producto));
	}

	/**
	 * @param database
	 * @param database2
	 */
	private static void añadirArticulo(Hashtable<String, Double> opcion, Hashtable<String, Double> database) {
		listarTodo(database);
		String articulo = JOptionPane.showInputDialog("Que articulo quieres añadir?");
		String cantidad = JOptionPane.showInputDialog("Que cantidad de este quieres?");

		double cantidadArticulo = Double.parseDouble(cantidad);

		opcion.put(articulo, cantidadArticulo);
	}

}
