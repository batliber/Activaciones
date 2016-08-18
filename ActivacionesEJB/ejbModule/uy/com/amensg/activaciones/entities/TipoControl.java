package uy.com.amensg.activaciones.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_control")
public class TipoControl extends BaseEntity {

	private static final long serialVersionUID = -1350410761274353137L;
	
	@Column(name = "desc_tipo_control")
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}