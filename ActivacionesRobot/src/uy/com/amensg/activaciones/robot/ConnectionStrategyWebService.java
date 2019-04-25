package uy.com.amensg.activaciones.robot;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import uy.com.amensg.activaciones.robot.util.Configuration;
import uy.com.amensg.activaciones.webservices.ActivacionesWebService;

public class ConnectionStrategyWebService implements IConnectionStrategy {

	public String getSiguienteMidParaActivar() {
		String result = "";
		
		try {
			Service service = Service.create(
				new URL(Configuration.getInstance().getProperty("ActivacionesWebServiceWSDLURL")), 
				new QName("http://webservices.logistica.amensg.com.uy/", "ActivacionesWebServiceService")
			);
			
			ActivacionesWebService webService = service.getPort(ActivacionesWebService.class);
			
			result = webService.getSiguienteMidParaActivar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public void actualizarDatosActivacion(
		String mid,
		String estadoActivacionId) {
		try {
			Service service = Service.create(
				new URL(Configuration.getInstance().getProperty("ActivacionesWebServiceWSDLURL")), 
				new QName("http://webservices.logistica.amensg.com.uy/", "ActivacionesWebServiceService")
			);
			
			ActivacionesWebService webService = service.getPort(ActivacionesWebService.class);
			
			webService.actualizarDatosActivacion(
				mid,
				estadoActivacionId
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}