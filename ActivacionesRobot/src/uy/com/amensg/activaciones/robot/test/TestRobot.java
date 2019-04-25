package uy.com.amensg.activaciones.robot.test;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import uy.com.amensg.activaciones.robot.util.Configuration;
import uy.com.amensg.activaciones.webservices.ActivacionesWebService;

public class TestRobot {

	public TestRobot() {
		try {
			Service service = Service.create(
				new URL(Configuration.getInstance().getProperty("ActivacionesWebServiceWSDLURL")), 
				new QName("http://webservices.logistica.amensg.com.uy/", "ActivacionesWebServiceService")
			);
				
			ActivacionesWebService webService = service.getPort(ActivacionesWebService.class);
				
			System.out.println(webService.getSiguienteMidParaActivar());
			
			webService.actualizarDatosActivacion("mid", "estadoActivacionId");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TestRobot();
	}
}