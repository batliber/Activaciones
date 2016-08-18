package uy.com.amensg.activaciones.robot.test;

import uy.com.amensg.activaciones.webservices.ActivacionesWS;
import uy.com.amensg.activaciones.webservices.ActivacionesWSProxy;

public class TestRobot {

	public TestRobot() {
		try {
			ActivacionesWS webService = new ActivacionesWSProxy();
			
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