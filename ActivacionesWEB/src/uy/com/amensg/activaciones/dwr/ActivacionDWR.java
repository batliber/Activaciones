package uy.com.amensg.activaciones.dwr;

import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.activaciones.bean.ActivacionBean;
import uy.com.amensg.activaciones.bean.IActivacionBean;
import uy.com.amensg.activaciones.entities.Activacion;
import uy.com.amensg.activaciones.entities.ActivacionTO;
import uy.com.amensg.activaciones.entities.MetadataConsultaResultado;
import uy.com.amensg.activaciones.entities.MetadataConsultaResultadoTO;
import uy.com.amensg.activaciones.entities.MetadataConsultaTO;

@RemoteProxy
public class ActivacionDWR {

	private IActivacionBean lookupBean() throws NamingException {
		String EARName = "Activaciones";
		String beanName = ActivacionBean.class.getSimpleName();
		String remoteInterfaceName = IActivacionBean.class.getName();
		String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
		Context context = new InitialContext();
		
		return (IActivacionBean) context.lookup(lookupName);
	}
	
	public MetadataConsultaResultadoTO listContextAware(MetadataConsultaTO metadataConsultaTO) {
		MetadataConsultaResultadoTO result = new MetadataConsultaResultadoTO();
		
		try {
			HttpSession httpSession = WebContextFactory.get().getSession(false);
			
			if ((httpSession != null) && (httpSession.getAttribute("sesion") != null)) {
				Long usuarioId = (Long) httpSession.getAttribute("sesion");
				
				IActivacionBean iActivacionBean = lookupBean();
				
				MetadataConsultaResultado metadataConsultaResultado = 
					iActivacionBean.list(
						MetadataConsultaDWR.transform(
							metadataConsultaTO
						),
						usuarioId
					);
				
				Collection<Object> registrosMuestra = new LinkedList<Object>();
				
				for (Object activacion : metadataConsultaResultado.getRegistrosMuestra()) {
					registrosMuestra.add(ActivacionDWR.transform((Activacion) activacion));
				}
				
				result.setRegistrosMuestra(registrosMuestra);
				result.setCantidadRegistros(metadataConsultaResultado.getCantidadRegistros());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Long countContextAware(MetadataConsultaTO metadataConsultaTO) {
		Long result = null;
		
		try {
			HttpSession httpSession = WebContextFactory.get().getSession(false);
			
			if ((httpSession != null) && (httpSession.getAttribute("sesion") != null)) {
				Long usuarioId = (Long) httpSession.getAttribute("sesion");
				
				IActivacionBean iActivacionBean = lookupBean();
				
				result = 
					iActivacionBean.count(
						MetadataConsultaDWR.transform(
							metadataConsultaTO
						),
						usuarioId
					);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String procesarArchivoEmpresa(String fileName, Long empresaId, Long tipoActivacionId) {
		String result = null;
		
		try {
			IActivacionBean iActivacionBean = lookupBean();
			
			HttpSession httpSession = WebContextFactory.get().getSession(false);
			Long usuarioId = (Long) httpSession.getAttribute("sesion");
			
			result = iActivacionBean.procesarArchivoEmpresa(fileName, empresaId, tipoActivacionId, usuarioId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static ActivacionTO transform(Activacion activacion) {
		ActivacionTO activacionTO = new ActivacionTO();
		
		activacionTO.setChip(activacion.getChip());
		activacionTO.setFechaActivacion(activacion.getFechaActivacion());
		activacionTO.setFechaImportacion(activacion.getFechaImportacion());
		activacionTO.setMid(activacion.getMid());
		
		if (activacion.getEmpresa() != null) {
			activacionTO.setEmpresa(EmpresaDWR.transform(activacion.getEmpresa()));
		}
		
		if (activacion.getTipoActivacion() != null) {
			activacionTO.setTipoActivacion(TipoActivacionDWR.transform(activacion.getTipoActivacion()));
		}
		
		if (activacion.getEstadoActivacion() != null) {
			activacionTO.setEstadoActivacion(EstadoActivacionDWR.transform(activacion.getEstadoActivacion()));
		}
		
		activacionTO.setFact(activacion.getFact());
		activacionTO.setId(activacion.getId());
		activacionTO.setTerm(activacion.getTerm());
		activacionTO.setUact(activacion.getUact());
		
		return activacionTO;
	}
}