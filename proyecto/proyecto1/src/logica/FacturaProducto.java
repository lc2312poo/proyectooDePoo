package logica;

public class FacturaProducto {

	private int cantidad;
	private int precio;
	
	private Producto producto;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public FacturaProducto(int cantidad, int precio, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
	}

	
	
	
}
