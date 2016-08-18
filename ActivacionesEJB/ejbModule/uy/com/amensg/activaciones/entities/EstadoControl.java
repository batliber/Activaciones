package uy.com.amensg.activaciones.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estado_controles")
public class EstadoControl extends BaseEntity {

	private static final long serialVersionUID = -6319094017290318752L;
	
	@Column(name = "nombre")
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}