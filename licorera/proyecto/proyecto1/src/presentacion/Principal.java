package presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import logica.Restaurante;

public class Principal {

	private Restaurante restaurante;
	private ArrayList<Integer> productosSeleccionados ;
	private Scanner sc = new Scanner(System.in);
	
	public Principal() {
		this.restaurante = new Restaurante();
		this.productosSeleccionados = new ArrayList<>();

	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.iniciar();
	}

	private void iniciar() {
		
		this.restaurante.leerArchivos();
		int op;
		do {
			System.out.println("Digite una opcion:\n" + 
					"0. Salir\n" + 
					"1. Ordenar productos de forma individual\n"+ 
					"2. Ordenar combo\n" + 
					"3. Imprimir Factura\n" + 
					"4. Imprimir productos\n" + 
					"5. Imprimir combos\n");
			op = sc.nextInt();
			if (op == 1) {
				this.seleccionarProductos();
			} else if (op == 2) {
				this.seleccionarCombo();
			} else if (op == 3) {
				this.restaurante.generarFactura(null, productosSeleccionados);
				productosSeleccionados = new ArrayList<Integer>();
				// imprimirFactura(Listado de producto "productosSeleccionados")
			} else if (op == 4) {
				this.restaurante.imprimirProductos();
			} else if (op == 5) {
				this.restaurante.imprimirCombos();
			}
		} while (op != 0);
		sc.close();
	}
	
	private void seleccionarProductos() {
		
		int op;
		
		this.restaurante.imprimirProductos();
		System.out.println("Digite codigo de producto :\n");
		op = sc.nextInt();
		productosSeleccionados.add(op);
		
		do {
			System.out.println("¿Desea realizar alguna modificación al pedido realizado?\n"+
					"0. No\n" +
					"1. Deseo agregar un ingrediente\n" + 
					"2. Deseo quitar un ingrediente\n");
			op = sc.nextInt();
			if (op == 1) {
			//	System.out.println("¿Qué adición desea realizar?\n");
			//	this.restaurante.buscarIngredientes(null);
				//agregar	
				do {
					System.out.println("¿Desea realizar otro cambio?\n" +
							"0. No\n" +
							"1. Sí\n");
				}while(op != 0);
				
			}else if (op == 2) {
				//Quitar
			}
		} while (op != 0);

	}
	
	private void seleccionarCombo() {
		
		int op;
		
		this.restaurante.imprimirCombos();
		System.out.println("Digite codigo del combo :\n");
		op = sc.nextInt();
		productosSeleccionados.add(op);
	}

}
