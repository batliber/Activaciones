package uy.com.amensg.activaciones.dwr;

import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.activaciones.bean.EstadoActivacionBean;
import uy.com.amensg.activaciones.bean.IEstadoActivacionBean;
import uy.com.amensg.activaciones.entities.EstadoActivacion;
import uy.com.amensg.activaciones.entities.EstadoActivacionTO;

@RemoteProxy
public class EstadoActivacionDWR {

	private IEstadoActivacionBean lookupBean() throws NamingException {
		String EARName = "Activaciones";
		String beanName = EstadoActivacionBean.class.getSimpleName();
		String remoteInterfaceName = IEstadoActivacionBean.class.getName();
		String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
		Context context = new InitialContext();
		
		return (IEstadoActivacionBean) context.lookup(lookupName);
	}
	
	public Collection<EstadoActivacionTO> list() {
		Collection<EstadoActivacionTO> result = new LinkedList<EstadoActivacionTO>();
		
		try {
			IEstadoActivacionBean iEstadoActivacionBean = lookupBean();
			
			for (EstadoActivacion estadoActivacion : iEstadoActivacionBean.list()) {
				result.add(transform(estadoActivacion));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static EstadoActivacionTO transform(EstadoActivacion estadoActivacion) {
		EstadoActivacionTO estadoActivacionTO = new EstadoActivacionTO();
		
		estadoActivacionTO.setNombre(estadoActivacion.getNombre());
		
		estadoActivacionTO.setFact(estadoActivacion.getFact());
		estadoActivacionTO.setId(estadoActivacion.getId());
		estadoActivacionTO.setTerm(estadoActivacion.getTerm());
		estadoActivacionTO.setUact(estadoActivacion.getUact());
		
		return estadoActivacionTO;
	}
	
	public static EstadoActivacion transform(EstadoActivacionTO estadoActivacionTO) {
		EstadoActivacion estadoActivacion = new EstadoActivacion();
		
		estadoActivacion.setNombre(estadoActivacionTO.getNombre());
		
		estadoActivacion.setFact(estadoActivacionTO.getFact());
		estadoActivacion.setId(estadoActivacionTO.getId());
		estadoActivacion.setTerm(estadoActivacionTO.getTerm());
		estadoActivacion.setUact(estadoActivacionTO.getUact());
		
		return estadoActivacion;
	}
}