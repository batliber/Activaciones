package uy.com.amensg.activaciones.entities;

import java.io.Serializable;
import java.util.Collection;

public class MetadataCondicion implements Serializable {

	private static final long serialVersionUID = 7458988412844741497L;
	
	private String campo;
	private String operador;
	private Collection<String> valores;

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Collection<String> getValores() {
		return valores;
	}

	public void setValores(Collection<String> valores) {
		this.valores = valores;
	}
}