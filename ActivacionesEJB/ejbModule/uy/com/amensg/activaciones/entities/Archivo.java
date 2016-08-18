package uy.com.amensg.activaciones.entities;

import java.io.Serializable;

public class Archivo implements Serializable {

	private static final long serialVersionUID = 5601501311399439464L;
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}