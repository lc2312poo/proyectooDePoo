package logica;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

	private int numero;
	private Date fecha;
	private int iva;
	private int valorTotal;
	
	
	private ArrayList<FacturaProducto> facturaProductos;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ArrayList<FacturaProducto> getFacturaProductos() {
		return facturaProductos;
	}
	
	public void setFacturaProductos(ArrayList<FacturaProducto> facturaProductos) {
		this.facturaProductos = facturaProductos;
	}
	
	public Factura(int numero, Date fecha) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.facturaProductos = new ArrayList<FacturaProducto>();
	}
	
	public void adicionarProducto(Producto producto, int cantidad) {
		FacturaProducto facturaProducto = new FacturaProducto(cantidad, producto.getPrecioVenta(), producto);
		this.facturaProductos.add(facturaProducto);		
	}
	public void calcularTotal() {
		int total = 0;
		for(FacturaProducto facturaProducto : this.facturaProductos) {
			total += facturaProducto.getPrecio() * facturaProducto.getCantidad();
		}
		this.valorTotal = total;
		this.iva = (int)(total * 0.19);
	}
}
