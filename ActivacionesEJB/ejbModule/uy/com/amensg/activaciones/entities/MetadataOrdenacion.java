package uy.com.amensg.activaciones.entities;

import java.io.Serializable;

public class MetadataOrdenacion implements Serializable {

	private static final long serialVersionUID = 9146888477667645856L;
	
	private String campo;
	private Boolean ascendente;

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Boolean getAscendente() {
		return ascendente;
	}

	public void setAscendente(Boolean ascendente) {
		this.ascendente = ascendente;
	}
}