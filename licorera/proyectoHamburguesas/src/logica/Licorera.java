package logica;

import java.util.ArrayList;
import java.util.Date;

import persistencia.Archivo;

public class Licorera {

	private ArrayList<TipoProducto> tipoProductos;
	private ArrayList<Cajero> cajeros;
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
	
	public Licorera() {
		this.tipoProductos = new ArrayList<TipoProducto>();
		this.cajeros = new ArrayList<Cajero>();
		this.facturas = new ArrayList<Factura>();
		this.clientes = new ArrayList<Cliente>();
		
	}

	public void ingresarTipoProducto(int id, String nombre) {
		TipoProducto tipoProducto = new TipoProducto(id, nombre);		
		this.tipoProductos.add(tipoProducto);
	}

	public void ingresarProducto(int idTipoProducto, int codigo, String nombre, int precioCompra, int precioVenta,
			int cantidad) {
		TipoProducto tipoProducto = this.buscarTipoProducto(idTipoProducto);
		if(tipoProducto != null) {
			tipoProducto.ingresarProducto(codigo, nombre, precioCompra, precioVenta, cantidad);
		}
		
	}

	private TipoProducto buscarTipoProducto(int idTipoProducto) {
		for(TipoProducto tipoProducto : this.tipoProductos) {
			if(tipoProducto.getId() == idTipoProducto) {
				return tipoProducto;
			}
		}
		return null;
	}

	public void imprimirProductos() {
		for(TipoProducto tipoProducto : this.tipoProductos) {
			for(Producto producto : tipoProducto.getProductos()) {
				System.out.println("Tipo: " + tipoProducto.getNombre());
				System.out.println("Codigo Producto: " + producto.getCodigo());
				System.out.println("Nombre: " + producto.getNombre());
				System.out.println("Precio Compra: " + producto.getPrecioCompra());
				System.out.println("Precio Venta: " + producto.getPrecioVenta());
				System.out.println("Cantidad: " + producto.getCantidad());
				System.out.println("-----------");
			}
		}
		
	}

	public void leerArchivos() {
		ArrayList<String> lineas;
		lineas = Archivo.leerArchivo("tipoProducto.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarTipoProducto(Integer.parseInt(datos[0]), datos[1]);
		}
		lineas = Archivo.leerArchivo("producto.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarProducto(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]));
		}		
		lineas = Archivo.leerArchivo("cajero.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarCajero(Integer.parseInt(datos[0]), datos[1], datos[2]);
		}		
		lineas = Archivo.leerArchivo("cliente.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarCliente(Integer.parseInt(datos[0]), datos[1], datos[2]);
		}		
	}

	public void ingresarCajero(int id, String nombre, String apellido) {
		Cajero cajero = new Cajero(id, nombre, apellido);
		this.cajeros.add(cajero);
	}

	public void ingresarCliente(int id, String nombre, String apellido) {
		Cliente cliente = new Cliente(id, nombre, apellido);
		this.clientes.add(cliente);		
	}

	public void ingresarFactura(int idCajero, int idCliente, Date fecha, ArrayList<int[]> productosComprados) {
		Cajero cajero = this.buscarCajero(idCajero);
		Cliente cliente = this.buscarCliente(idCliente);
		int numero = this.facturas.size() + 1;
		Factura factura = new Factura(numero, fecha, cajero, cliente);
		for(int[] datos : productosComprados) {
			Producto producto = this.buscarProducto(datos[0]);
			factura.adicionarProducto(producto, datos[1]);
		}
		factura.calcularTotal();
		this.facturas.add(factura);
	}

	private Producto buscarProducto(int idProducto) {
		for(TipoProducto tipoProducto : this.tipoProductos) {
			for(Producto producto : tipoProducto.getProductos()) {
				if(producto.getCodigo() == idProducto) {
					return producto;
				}
			}
		}
		return null;
	}

	private Cliente buscarCliente(int idCliente) {
		for(Cliente cliente : this.clientes) {
			if(cliente.getId() == idCliente) {
				return cliente;
			}
		}
		return null;
	}

	private Cajero buscarCajero(int idCajero) {
		for(Cajero cajero : this.cajeros) {
			if(cajero.getId() == idCajero) {
				return cajero;
			}
		}
		return null;
	}

	public void imprimirFacturas() {
		for(Factura factura : this.facturas) {
			System.out.println("-------");
			System.out.println(factura.getNumero() + " -> " + factura.getFecha() + " -> " + factura.getValorTotal() + " -> " + factura.getIva() + " -> " + factura.getCajero().getNombre() + " -> " + factura.getCliente().getNombre());
			for(FacturaProducto facturaProducto : factura.getFacturaProductos()) {
				System.out.println(facturaProducto.getProducto().getNombre() + " -> " + facturaProducto.getCantidad() + " -> " + facturaProducto.getPrecio());
			}
		}
		
	}
}
