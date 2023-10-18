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
	//ingredietnes
	
	public Restaurante() {
//		this.tipoProductos = new ArrayList<TipoProducto>();
		this.productos = new ArrayList<Producto>();
		this.combos = new ArrayList<Combos>();
		this.ingredientes = new ArrayList<Ingredientes>();
		//ingredientes, componentes
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
				System.out.println("Hamburguesa: " + combos.getHamburguesa().getNombre());
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
			Producto hamburguesa = buscarProducto(Integer.parseInt(datos[1]));
			Producto bebida = buscarProducto(Integer.parseInt(datos[2]));
			Producto acompanamiento = buscarProducto(Integer.parseInt(datos[3]));
						
			this.ingresarCombos(Integer.parseInt(datos[0]), hamburguesa, bebida, acompanamiento);
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
		//	componentes.add(componente);
		}
	}
	/*
	public {
		
		Producto = hamburguesa , 2;
		Componentes = cod 2; //1,2,3,5,6,7,10,11,9
		lista ingredientes = buscarIngredientes(2)
				imprimir lista de ingredientes 
	}
	*/
	
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
	
	
/*	
	private Producto buscarCombo(Integer idCombo) {
		for(Producto producto : this.productos) {
			if(producto.getCodigo() == idCombo) {
				return producto;
			}
		}
		return null;
	}
	*/

	public void generarFactura(Date fecha, ArrayList<Integer> productosSeleccionados) {//[1,3,5]
		
		ArrayList<Producto> listaProductosComprados = new ArrayList<Producto>();
		for(Integer productos : productosSeleccionados) {
			Producto productoComprado = buscarProducto(productos);
			if(productoComprado != null) {
				listaProductosComprados.add(productoComprado);
			}
		}
		
		Integer total = 0;
		

		for(Producto listaProductos : listaProductosComprados) {
			System.out.println("Nombre del Producto: \n" + listaProductos.getNombre());
		}
		for(Producto listaProductos : listaProductosComprados) {
			System.out.println("Codigo del producto: \n" + listaProductos.getCodigo());
		}

		for(Producto listaProductos : listaProductosComprados) {
			System.out.println("Costo de producto: \n" + listaProductos.getPrecioVenta());
		}
		for(Producto listaProductos : listaProductosComprados) {
			total += listaProductos.getPrecioVenta();
		}
			System.out.print("Precio total a pagar: \n" + total);
			System.out.print("\n"); 
			System.out.print("Gracias por su compra :D\n");
	}
	

	/*public void generarFacturaCombos(Date fecha, ArrayList<Integer> productosSeleccionados) {
		
		ArrayList<Combos> listaCombosComprados = new ArrayList<Combos>();
		for(Integer combos : productosSeleccionados) {
			Combo comboComprado = buscarCombo(productos);
			if(comboComprado != null) {
				listaCombosComprados.add(comboComprado);
			}
		}
		
		Integer total = 0;
		

		for(Producto listaCombos : listaCombosComprados) {
			System.out.println("Nombre del Producto: \n" + listaCombos.getNombre());
		}
		for(Producto listaCombos : listaCombosComprados) {
			System.out.println("Codigo del producto: \n" + listaCombos.getCodigo());
		}

		for(Producto listaCombos : listaCombosComprados) {
			System.out.println("Costo de producto: \n" + listaCombos.getPrecioVenta());
		}
		for(Producto listaCombos : listaCombosComprados) {
			total += listaCombos.getPrecioVenta();
		}
			System.out.print("Precio total a pagar: \n" + total);
			System.out.print("\n"); 
			System.out.print("Gracias por su compra :D\n");
	}

	
	*/
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

/*
	public void imprimirFacturas() {
		for(Factura factura : this.hamburguesas) {
			System.out.println("-------");
			System.out.println(factura.getNumero() + "\n" + factura.getFecha() + "\n" + factura.getValorTotal() + "\n" + factura.getIva());
			for(FacturaProducto facturaProducto : factura.getFacturaProductos()) {
				System.out.println(facturaProducto.getProducto().getNombre() + "\n" + facturaProducto.getCantidad() + "\n" + facturaProducto.getPrecio());
			}
		}
		
	}*/
}
