package uy.com.amensg.activaciones.entities;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class ArchivoTO {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}