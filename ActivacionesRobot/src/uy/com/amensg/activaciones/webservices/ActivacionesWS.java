package uy.com.amensg.activaciones.webservices;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ActivacionesWS extends Remote {
    
	public String getSiguienteMidParaActivar() throws RemoteException;
	
    public void actualizarDatosActivacion(String mid, String estadoActivacionId) throws RemoteException;
}