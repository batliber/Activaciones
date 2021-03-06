package uy.com.amensg.activaciones.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estado_activaciones")
public class EstadoActivacion extends BaseEntity {

	private static final long serialVersionUID = -1159394957307983988L;
	
	@Column(name = "nombre")
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}