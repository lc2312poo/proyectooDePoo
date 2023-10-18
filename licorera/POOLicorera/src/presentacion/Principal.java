package presentacion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import logica.Licorera;

public class Principal {
	
	private Licorera licorera;
	
	public Principal() {
		this.licorera = new Licorera();
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.iniciar();
	}	

	private void iniciar() {
		Scanner sc = new Scanner(System.in);
		int op;
		do {
			System.out.println("Digite una opcion:\n"
					+ "0. Salir\n"
					+ "1. Ingresar Tipo Producto\n"
					+ "2. Ingresar Producto\n"
					+ "3. Ingresar Cajero\n"
					+ "4. Ingresar Cliente\n"
					+ "5. Ingresar Factura\n"
					+ "6. Imprimir Productos\n"
					+ "7. Imprimir Facturas\n"
					+ "8. Leer Archivos\n");
			op = sc.nextInt();
			if(op == 1) {
				System.out.println("Digite id: ");
				int id = sc.nextInt();
				System.out.println("Digite nombre: ");
				String nombre = sc.next();				
				this.licorera.ingresarTipoProducto(id, nombre);
			}else if(op == 2) {
				System.out.println("Digite id del Tipo de Producto: ");
				int idTipoProducto = sc.nextInt();
				System.out.println("Digite codigo: ");
				int codigo = sc.nextInt();
				System.out.println("Digite nombre: ");
				String nombre = sc.next();				
				System.out.println("Digite precio compra: ");
				int precioCompra = sc.nextInt();				
				System.out.println("Digite precio venta: ");
				int precioVenta = sc.nextInt();				
				System.out.println("Digite cantidad: ");
				int cantidad = sc.nextInt();	
				this.licorera.ingresarProducto(idTipoProducto, codigo, nombre, precioCompra, precioVenta, cantidad);
			}else if(op == 3) {
				System.out.println("Digite id: ");
				int id = sc.nextInt();
				System.out.println("Digite nombre: ");
				String nombre = sc.next();				
				System.out.println("Digite apellido: ");
				String apellido = sc.next();								
				this.licorera.ingresarCajero(id, nombre, apellido);
			}else if(op == 4) {
				System.out.println("Digite id: ");
				int id = sc.nextInt();
				System.out.println("Digite nombre: ");
				String nombre = sc.next();				
				System.out.println("Digite apellido: ");
				String apellido = sc.next();								
				this.licorera.ingresarCliente(id, nombre, apellido);
			}else if(op == 5) {
				System.out.println("Digite id del Cajero: ");
				int idCajero = sc.nextInt();
				System.out.println("Digite id del Cliente: ");
				int idCliente = sc.nextInt();
				System.out.println("Digite la fecha: ");
				String fechaTexto = sc.next();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = null;
				try {
					fecha = dateFormat.parse(fechaTexto);
				} catch (ParseException e) {
					e.printStackTrace();
				//	System.out.println("a");
				} 
				int otroProducto;
				ArrayList<int[]> productosComprados = new ArrayList<int[]>();
				do {
					int datos[] = new int[2];
					System.out.println("Digite id del producto: ");
					int idProducto = sc.nextInt();
					System.out.println("Digite cantidad del producto: ");
					int cantidadProducto = sc.nextInt();
					datos[0] = idProducto;
					datos[1] = cantidadProducto;
					productosComprados.add(datos);					
					System.out.println("Desea ingresar otro producto?\n"
							+ "1. Si\n"
							+ "2. No\n");
					otroProducto = sc.nextInt();
				}while(otroProducto == 1);
				this.licorera.ingresarFactura(idCajero, idCliente, fecha, productosComprados);
			} else if(op == 6) {
				this.licorera.imprimirProductos();
			} else if(op == 7) {
				this.licorera.imprimirFacturas();
			} else if(op == 8) {
				this.licorera.leerArchivos();
			}
		}while(op != 0);
		sc.close();
	}
}
