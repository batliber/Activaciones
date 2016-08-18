package uy.com.amensg.activaciones.entities;

import java.util.Date;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class ActivacionTO extends BaseTO {

	private Long mid;
	private Date fechaActivacion;
	private String chip;
	private Date fechaImportacion;
	private Long idTipoActivacion;
	private EmpresaTO empresa;
	private TipoActivacionTO tipoActivacion;
	private EstadoActivacionTO estadoActivacion;

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

	public Long getIdTipoActivacion() {
		return idTipoActivacion;
	}

	public void setIdTipoActivacion(Long idTipoActivacion) {
		this.idTipoActivacion = idTipoActivacion;
	}

	public EmpresaTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}

	public TipoActivacionTO getTipoActivacion() {
		return tipoActivacion;
	}

	public void setTipoActivacion(TipoActivacionTO tipoActivacion) {
		this.tipoActivacion = tipoActivacion;
	}

	public EstadoActivacionTO getEstadoActivacion() {
		return estadoActivacion;
	}

	public void setEstadoActivacion(EstadoActivacionTO estadoActivacion) {
		this.estadoActivacion = estadoActivacion;
	}	
}