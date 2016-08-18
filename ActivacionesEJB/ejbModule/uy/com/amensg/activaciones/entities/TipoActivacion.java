package uy.com.amensg.activaciones.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_activacion")
public class TipoActivacion extends BaseEntity {

	private static final long serialVersionUID = -4035749302191640991L;

	@Column(name = "desc_tipo_activacion")
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}