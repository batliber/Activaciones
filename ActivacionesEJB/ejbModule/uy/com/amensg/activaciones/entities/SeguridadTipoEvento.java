package uy.com.amensg.activaciones.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "seguridad_tipo_evento")
public class SeguridadTipoEvento extends BaseEntity {

	private static final long serialVersionUID = 1719477189697576005L;
	
	@Column(name = "descripcion")
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}