package uy.com.amensg.activaciones.bean;

import java.util.Collection;
import java.util.Map;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.Activacion;
import uy.com.amensg.activaciones.entities.MetadataConsulta;
import uy.com.amensg.activaciones.entities.MetadataConsultaResultado;

@Remote
public interface IActivacionBean {

	public MetadataConsultaResultado list(MetadataConsulta metadataConsulta, Long usuarioId);

	public Long count(MetadataConsulta metadataConsulta, Long usuarioId);

	public String preprocesarArchivoEmpresa(String fileName, Long empresaId);
	
	public Map<Long, Integer> preprocesarConjunto(Collection<Long> mids, Long empresaId);
	
	public String procesarArchivoEmpresa(String fileName, Long empresaId, Long tipoActivacionId, Long loggedUsuarioId);
	
	public Activacion getSiguienteMidParaActivar();
	
	public void actualizarDatosActivacion(Long mid, Long estadoActivacionId);
}