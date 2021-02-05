import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Víctor Lozano
 *
 */
public class TasquesUD7_2 {

	public static void main(String[] args) {
		ArrayList<Double> carrito = new ArrayList<>();
		ArrayList<Double> carritoMasIVA = new ArrayList<>();
		ArrayList<Double> iva = new ArrayList<>();
		boolean activa = true;
		while (activa) {
			activa = opciones(carrito, carritoMasIVA, iva);
		}

	}

	/**
	 * @param carrito
	 * @param carritoMasIVA
	 * @param iva 
	 * @return
	 * 
	 */
	private static boolean opciones(ArrayList<Double> carrito, ArrayList<Double> carritoMasIVA, ArrayList<Double> iva) {
		boolean activa = true;

		String opcion = JOptionPane.showInputDialog("Que quieres hacer: Comprar || Pagar || Cerrar");

		switch (opcion.toLowerCase()) {
		case "comprar":
			comprar(carrito, carritoMasIVA, iva);
			break;
		case "pagar":
			pagar(carrito, carritoMasIVA, iva);
			break;
		case "cerrar":
			activa = false;
			break;
		default:
			break;
		}
		return activa;
	}

	/**
	 * @param carrito
	 * @param carritoMasIVA
	 * @param iva 
	 */
	private static void pagar(ArrayList<Double> carrito, ArrayList<Double> carritoMasIVA, ArrayList<Double> iva) {
		double total = 0;

		System.out.println("Total productos: " + carrito.size());
		for (int i = 0; i < carrito.size(); i++) {
			System.out.println("Producto " + i);
			System.out.println("Precio bruto: " + carrito.get(i));
			System.out.println("Precio con IVA: " + carritoMasIVA.get(i));
			System.out.println("IVA aplicado: " + iva.get(i));
			total = total + carritoMasIVA.get(i);
		}
		String cantidadPagada = JOptionPane.showInputDialog("El precio final es de " + total + ". Cuanto pagas?");
		double pagado = Double.parseDouble(cantidadPagada);
		
		System.out.println("Precio final: " + total);
		System.out.println("Pagado: " + pagado);
		System.out.println("Cambio: " + (pagado - total));
		
	}

	/**
	 * @param carrito
	 * @param carritoMasIVA
	 * @param iva 
	 */
	private static void comprar(ArrayList<Double> carrito, ArrayList<Double> carritoMasIVA, ArrayList<Double> iva) {
		String productos = JOptionPane.showInputDialog("Cuantos productos tiene el carrito");
		int produtosCarrito = Integer.parseInt(productos);

		for (int i = 0; i < produtosCarrito; i++) {
			String objeto = JOptionPane.showInputDialog("Precio producto" + i);
			double precio = Double.parseDouble(objeto);
			carrito.add(precio);
			String impuesto = JOptionPane.showInputDialog("IVA del producto: 21% || 4%");
			if (impuesto.equals("21")) {
				carritoMasIVA.add(precio + (precio * 0.21));
				iva.add((double) 21);
			} else {
				carritoMasIVA.add(precio + (precio * 0.04));
				iva.add((double) 4);
			}

		}
	}

}
