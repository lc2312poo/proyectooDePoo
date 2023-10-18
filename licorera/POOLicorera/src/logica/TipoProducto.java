package logica;

import java.util.ArrayList;

public class TipoProducto {
	private int id;
	private String nombre;
	private ArrayList<Producto> productos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public TipoProducto(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.productos = new ArrayList<Producto>();
	}
	public void ingresarProducto(int codigo, String nombre, int precioCompra, int precioVenta, int cantidad) {
		Producto producto = new Producto(codigo, nombre, precioCompra, precioVenta, cantidad);
		this.productos.add(producto);		
	}
	
	
	
	
	
}
