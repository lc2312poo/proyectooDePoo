package presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import logica.Restaurante;

public class Principal {

	private Restaurante restaurante;
	private ArrayList<Integer> productosSeleccionados ;
	private ArrayList<Integer> combosSeleccionados ;
	private Scanner sc = new Scanner(System.in);
	
	public Principal() {
		this.restaurante = new Restaurante();
		this.productosSeleccionados = new ArrayList<>();
		this.combosSeleccionados = new ArrayList<>();

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
					"5. Imprimir combos\n" +
					"6. Imprimir factura de combos\n");
			
			op = sc.nextInt();
			if (op == 1) {
				this.seleccionarProductos();
			} else if (op == 2) {
				this.seleccionarCombo();
			} else if (op == 3) {
				this.restaurante.generarFactura(null, productosSeleccionados);
				productosSeleccionados = new ArrayList<Integer>();
			} else if (op == 4) {
				this.restaurante.imprimirProductos();
			} else if (op == 5) {
				this.restaurante.imprimirCombos();
			}else if (op == 6) {
				this.restaurante.generarFacturaCombos(null, combosSeleccionados);
				combosSeleccionados = new ArrayList<Integer>();
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
		
	}
	
	private void seleccionarCombo() {
		
		int op;
		
		this.restaurante.imprimirCombos();
		System.out.println("Digite codigo del combo :\n");
		op = sc.nextInt();
		combosSeleccionados.add(op);
	}

}
