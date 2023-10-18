package logica;

public class Producto {
	
	//private TipoProducto tipoProducto;
	private int codigo;
	private String nombre;
	private int precioVenta;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
	/*public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	*/
	public Producto(/*TipoProducto tipoProducto,*/ int codigo, String nombre, int precioVenta) {
	//	this.tipoProducto = tipoProducto;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
	}
	
	
	
	
}
