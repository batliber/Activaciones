package uy.com.amensg.activaciones.robot;

public class ActivacionesProxy {

	private IConnectionStrategy iConnectionStrategy = new ConnectionStrategyWebService();
	
	public void getSiguienteMidParaActivar() {
		System.out.println(iConnectionStrategy.getSiguienteMidParaActivar());
	}
	
	public void actualizarDatosActivacion(String mid, String estadoActivacionId) {
		iConnectionStrategy.actualizarDatosActivacion(mid, estadoActivacionId);
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