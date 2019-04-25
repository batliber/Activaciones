package uy.com.amensg.activaciones.robot;

public interface IConnectionStrategy {

	public String getSiguienteMidParaActivar();

	public void actualizarDatosActivacion(
		String mid,
		String estadoActivacionId
	);
}