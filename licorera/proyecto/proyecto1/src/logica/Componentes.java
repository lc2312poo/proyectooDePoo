package logica;

import java.util.ArrayList;

public class Componentes{

	private ArrayList<String> ingredientes;
	private String tipoAlimento;
	
	public Componentes() {}


	public Componentes(ArrayList<String> componentes) {
		this.ingredientes = componentes;
	}
	
	public String getTipoAlimento() {
		return tipoAlimento;
	}


	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}


	public ArrayList<String> getComponentes() {
		return this.ingredientes;
	}

	public void setComponentes(ArrayList<String> componentes) {
		this.ingredientes = componentes;
	}

}
