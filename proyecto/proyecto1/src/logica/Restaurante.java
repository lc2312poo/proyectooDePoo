package logica;

import java.util.ArrayList;
import java.util.Date;

import persistencia.Archivo;

public class Restaurante {

	private ArrayList<Producto> productos;
	private ArrayList<Combos> combos;
	private ArrayList<Factura> facturas;
	private ArrayList<Componentes> componentes;
	private ArrayList<Ingredientes> ingredientes;
	
	public Restaurante() {

		this.productos = new ArrayList<Producto>();
		this.combos = new ArrayList<Combos>();
		this.ingredientes = new ArrayList<Ingredientes>();
		this.componentes = new ArrayList<Componentes>();

	} 

	public void ingresarProducto(int codigo, String nombre, int precioVenta) {
		Producto productosT = new Producto(codigo, nombre, precioVenta);		
		this.productos.add(productosT);
	}
	
	public void ingresarCombos(int idCombos, Producto hamburguesa, Producto bebida, Producto acompanamiento) {
		Combos combos = new Combos(idCombos, hamburguesa, bebida, acompanamiento);		
		this.combos.add(combos);
	}
		

	public void imprimirProductos() {
		for(Producto producto : this.productos) {
				System.out.println("Codigo Producto: " + producto.getCodigo());
				System.out.println("Nombre: " + producto.getNombre());
				System.out.println("Precio Venta: " + producto.getPrecioVenta());
				System.out.println("-----------");
		}
	}

	public void imprimirCombos() {
		for(Combos combos: this.combos) {
			Double precio = (combos.getHamburguesa().getPrecioVenta() + 
					combos.getBebida().getPrecioVenta() + 
					combos.getAcompanamiento().getPrecioVenta())*0.9;
				System.out.println("Codigo Producto: " + combos.getId());
				System.out.println("Producto: " + combos.getHamburguesa().getNombre());
				System.out.println("Bebida: " + combos.getBebida().getNombre());
				System.out.println("Acompañamiento: " + combos.getAcompanamiento().getNombre());
				System.out.println("Precio Venta: " + precio);
				System.out.println("-----------");
		}
	}
	
	public void leerArchivos() {
		ArrayList<String> lineas;
		lineas = Archivo.leerArchivo("Productos.dat");
		for(String linea : lineas) {
			String datos[]= linea.split(",");
						
			this.ingresarProducto(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]));
		}
		
		lineas = Archivo.leerArchivo("Combos.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(",");
			Producto producto = buscarProducto(Integer.parseInt(datos[1]));
			Producto bebida = buscarProducto(Integer.parseInt(datos[2]));
			Producto acompanamiento = buscarProducto(Integer.parseInt(datos[3]));
						
			this.ingresarCombos(Integer.parseInt(datos[0]), producto, bebida, acompanamiento);
		}
		
		lineas = Archivo.leerArchivo("Ingredientes.dat");
		
		for(String linea : lineas) {
			String datos[] = linea.split(",");
			Ingredientes ingrediente = new Ingredientes(Integer.parseInt(datos[0]), datos[1]);
			
			this.ingredientes.add(ingrediente);
		}
			
		lineas = Archivo.leerArchivo("componente.dat");
		for(String linea: lineas) {
			Componentes componente = new Componentes();
			ArrayList<String> ingredientes = new ArrayList<>();
			
			String datos[]= linea.split(",");
		
			for(int i = 1; i < datos.length; i ++) {
				ingredientes.add(datos[i]);
			}
			
			componente.setTipoAlimento(datos[0]);
			componente.setComponentes(ingredientes);
			componentes.add(componente);
		}
	}

	
	public Ingredientes buscarIngredientes(Integer idIngrediente) {
		for(Ingredientes ingrediente : this.ingredientes) {
			if(ingrediente.getCodigo() == idIngrediente) {
				return ingrediente;
			}
		}
		return null;
	}
	
	
	private Producto buscarProducto(Integer idProducto) {
		for(Producto producto : this.productos) {
			if(producto.getCodigo() == idProducto) {
				return producto;
			}
		}
		return null;
	}
	
	
	private Combos buscarCombo(Integer idCombo) {
		for(Combos combo : this.combos) {
			if(combo.getId() == idCombo) {
				return combo;
			}
		}
		return null;
	}
	

	public void generarFactura(Date fecha, ArrayList<Integer> productosSeleccionados) {
		
		ArrayList<Producto> listaProductosComprados = new ArrayList<Producto>();
		for(Integer productos : productosSeleccionados) {
			Producto productoComprado = buscarProducto(productos);
			if(productoComprado != null) {
				listaProductosComprados.add(productoComprado);
			}
		}
		
		Integer total = 0;
		

		for(Producto listaProductos : listaProductosComprados) {
			System.out.println("Nombre del Producto:  " + listaProductos.getNombre());
			System.out.println("Codigo del producto:   " + listaProductos.getCodigo());
			System.out.println("Costo de producto:   " + listaProductos.getPrecioVenta());
			total += listaProductos.getPrecioVenta();
			System.out.println("\n------------------------------------\n");
		}
			System.out.print("Precio total a pagar:  " + total);
			System.out.print("\n"); 
			System.out.print("Gracias por su compra :D\n");
			System.out.println("\n");
	}
	

	public void generarFacturaCombos(Date fecha, ArrayList<Integer> combosSeleccionados) {
		
		ArrayList<Combos> listaCombosComprados = new ArrayList<Combos>();
		for(Integer combos : combosSeleccionados) {
			Combos comboComprado = buscarCombo(combos);
			if(comboComprado != null) {
				listaCombosComprados.add(comboComprado);
			}
		}
		
		Double total = 0.0;
		


		for(Combos listaCombos : listaCombosComprados) {
			System.out.println("Codigo del producto: \n" + listaCombos.getId());
	
			Double precio = (listaCombos.getHamburguesa().getPrecioVenta() + 
			listaCombos.getBebida().getPrecioVenta() + 
			listaCombos.getAcompanamiento().getPrecioVenta())*0.9;
			System.out.println("Costo de producto: \n" + precio);
			
			total += precio;
		}
		
			System.out.print("Precio total a pagar: \n" + total);
			System.out.print("\n"); 
			System.out.print("Gracias por su compra :D\n");
	}

	
	
	public void ingresarFactura(Date fecha, ArrayList<int[]> productosComprados) {
	
		int numero = this.facturas.size() + 1;
		Factura factura = new Factura(numero, fecha);
		for(int[] datos : productosComprados) {
			Producto producto = this.buscarProducto(datos[0]);
			factura.adicionarProducto(producto, datos[1]);
		}
		factura.calcularTotal();
		this.facturas.add(factura);
	}

}