package uy.com.amensg.activaciones.robot;

import uy.com.amensg.activaciones.webservices.ActivacionesWS;
import uy.com.amensg.activaciones.webservices.ActivacionesWSProxy;

public class ActivacionesProxy {

	public void getSiguienteMidParaActivar() {
		try {
			ActivacionesWS webService = new ActivacionesWSProxy();
			
			System.out.println(webService.getSiguienteMidParaActivar());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarDatosActivacion(String mid, String estadoActivacionId) {
		try {
			ActivacionesWS webService = new ActivacionesWSProxy();
			
			webService.actualizarDatosActivacion(mid, estadoActivacionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if (args[0].equals("getSiguienteMidParaActivar")) {
			new ActivacionesProxy().getSiguienteMidParaActivar();
		} else if (args[0].equals("actualizarDatosMid")) {
			new ActivacionesProxy().actualizarDatosActivacion(
				args[1],
				args[2]
			);
		}
	}
}