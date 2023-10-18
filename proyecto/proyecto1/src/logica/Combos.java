package logica;

public class Combos extends Restaurante{

	private int id;
	private Producto hamburguesa;
	private Producto bebida;
	private Producto acompanamiento;
	private int precioVenta;
	
	public Combos(int id, Producto hamburguesa, Producto bebida, Producto acompanamiento) {
		super();
		this.id = id;
		this.hamburguesa = hamburguesa;
		this.bebida = bebida;
		this.acompanamiento = acompanamiento;
	}
	
	

	public Combos() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getHamburguesa() {
		return hamburguesa;
	}

	public void setHamburguesa(Producto hamburguesa) {
		this.hamburguesa = hamburguesa;
	}

	public Producto getBebida() {
		return bebida;
	}

	public void setBebida(Producto bebida) {
		this.bebida = bebida;
	}

	public Producto getAcompanamiento() {
		return acompanamiento;
	}

	public void setAcompanamiento(Producto acompanamiento) {
		this.acompanamiento = acompanamiento;
	}
	
	public int getPrecioVenta() {
		this.imprimirCombos();
		return precioVenta;
	}
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
}
