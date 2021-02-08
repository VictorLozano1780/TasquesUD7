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
public class TasquesUD7_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean activo = true;

		Hashtable<String, Double> stock = new Hashtable<>(); // Creacion de Stock inicial
		stock.put("Macarrones", 25.0);
		stock.put("Raviolis", 25.0);
		stock.put("Espaguetis", 25.0);
		stock.put("Tallarines", 25.0);
		stock.put("Fideos", 25.0);
		stock.put("Pan", 25.0);
		stock.put("Cereales", 25.0);
		stock.put("Galletas", 25.0);
		stock.put("Turron", 25.0);
		stock.put("Cerveza", 25.0);
		Hashtable<String, Double> precio = new Hashtable<>(); // Creacion de precio de los productos inicial
		precio.put("Macarrones", 0.99);
		precio.put("Raviolis", 2.0);
		precio.put("Espaguetis", 1.99);
		precio.put("Tallarines", 1.99);
		precio.put("Fideos", 2.99);
		precio.put("Pan", 0.40);
		precio.put("Cereales", 3.0);
		precio.put("Galletas", 7.0);
		precio.put("Turron", 4.5);
		precio.put("Cerveza", 7.89);
		Hashtable<String, Double> carrito = new Hashtable<>();
		while (activo) {
			String opcion = JOptionPane.showInputDialog(
					"1. Mostrar stock || 2. Mostrar carrito || 3. Mostrar precios productos|| "
					+ "4. Añadir stock || 5. Añadir producto al carrito || 6. Pagar || Otro. Cerrar App");
			switch (opcion) {
			case "1":
				System.out.println("\nStock:\n");
				imprimirHash(stock);
				break;
			case "2":
				if (carrito.isEmpty()) {
					System.out.println("El carrito esta vacio");
				} else {
					System.out.println("\nCarrito:\n");
					imprimirHash(carrito);
				}
				break;
			case "3":
				System.out.println("\nPrecios: \n");
				imprimirHash(precio);
				break;
			case "4":
				añadirStock(stock);
				break;
			case "5":
				añadirCarrito(carrito, stock);
				break;
			case "6":
				pagar(carrito, precio);
				break;
			default:
				activo = false;
			}
		}

	}

	/**
	 * @param carrito
	 * @param precio
	 */
	private static void pagar(Hashtable<String, Double> carrito, Hashtable<String, Double> precio) {
		double precioFinal = 0;
		for (Entry<String, Double> entry : carrito.entrySet()) {
			entry.getKey();
			double precioProducto = precio.get(entry.getKey());
			precioFinal += precioProducto * entry.getValue();
		}
		System.out.println("El precio final es de " + precioFinal);
		
	}

	/**
	 * @param carrito
	 * @param stock
	 */
	private static void añadirCarrito(Hashtable<String, Double> carrito, Hashtable<String, Double> stock) {
		boolean activado = true;
		String producto = JOptionPane.showInputDialog("Que producto quieres añadir al carrito?");
		for (Entry<String, Double> entry : stock.entrySet()) {
			if (producto.equals(entry.getKey()) && activado) {
				String canti = JOptionPane.showInputDialog("Que cantidad quieres llevarte");
				double cantidad = Double.parseDouble(canti);
				if (cantidad <= stock.get(producto)) {
					stock.put(producto, stock.get(producto) - cantidad); // Actualiza el stock quitando los productos
																			// que te llevas
					carrito.put(producto, cantidad); // Actualiza el carrito añadiendo el producto
					System.out.println("Se ha añadido " + producto + " al carrito");
				} else {
					System.out.println("No hay tanto stock");
				}
				activado = false;
			}
		}

	}

	/**
	 * @param stock
	 */
	private static void añadirStock(Hashtable<String, Double> stock) {
		String producto = JOptionPane.showInputDialog("Que producto quieres añadir?");
		String canti = JOptionPane.showInputDialog("Cuanto stock añades?");
		double cantidad = Double.parseDouble(canti);

		stock.put(producto, stock.get(producto) + cantidad);

	}

	/**
	 * @param hash
	 */
	private static void imprimirHash(Hashtable<String, Double> hash) {
		for (Entry<String, Double> entry : hash.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

}
