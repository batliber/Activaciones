package uy.com.amensg.activaciones.webservices;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import uy.com.amensg.activaciones.bean.ActivacionBean;
import uy.com.amensg.activaciones.bean.IActivacionBean;
import uy.com.amensg.activaciones.entities.Activacion;

@Stateless
@WebService()
public class ActivacionesWS {

	@WebMethod
	public String getSiguienteMidParaActivar() {
		String result = "";
		
		try {
			IActivacionBean iActivacionBean = lookupBean();
			
			Activacion activacion = iActivacionBean.getSiguienteMidParaActivar();
			
			if (activacion != null) {
				result = 
					activacion.getMid() + " " 
					+ activacion.getChip() + " "
					+ activacion.getTipoActivacion().getId() + " "
					+ "empresaUsuarioACM" + " " 
					+ "empresaPassACM";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@WebMethod
	public void actualizarDatosActivacion(String mid, String estadoActivacionId) {
		try {
			IActivacionBean iActivacionBean = lookupBean();
			
			iActivacionBean.actualizarDatosActivacion(new Long(mid), new Long(estadoActivacionId));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private IActivacionBean lookupBean() throws NamingException {
		String EARName = "Activaciones";
		String beanName = ActivacionBean.class.getSimpleName();
		String remoteInterfaceName = IActivacionBean.class.getName();
		String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
		Context context = new InitialContext();
		
		return (IActivacionBean) context.lookup(lookupName);
	}
}