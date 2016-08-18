package uy.com.amensg.activaciones.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "activaciones")
public class Activacion extends BaseEntity {

	private static final long serialVersionUID = 1796252337841102923L;

	@Column(name = "mid")
	private Long mid;
	
	@Column(name = "fecha_activacion")
	private Date fechaActivacion;
	
	@Column(name = "chip")
	private String chip;
	
	@Column(name = "fecha_importacion")
	private Date fechaImportacion;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@JoinColumn(name = "id_empresa", nullable = true)
	private Empresa empresa;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@JoinColumn(name = "id_tipo_activacion", nullable = true)
	private TipoActivacion tipoActivacion;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@JoinColumn(name = "id_estado_activaciones", nullable = true)
	private EstadoActivacion estadoActivacion;

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public Date getFechaImportacion() {
		return fechaImportacion;
	}

	public void setFechaImportacion(Date fechaImportacion) {
		this.fechaImportacion = fechaImportacion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public TipoActivacion getTipoActivacion() {
		return tipoActivacion;
	}

	public void setTipoActivacion(TipoActivacion tipoActivacion) {
		this.tipoActivacion = tipoActivacion;
	}

	public EstadoActivacion getEstadoActivacion() {
		return estadoActivacion;
	}

	public void setEstadoActivacion(EstadoActivacion estadoActivacion) {
		this.estadoActivacion = estadoActivacion;
	}
}