package uy.com.amensg.activaciones.webservices;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class ActivacionesWSProxy implements ActivacionesWS {

	private String _endpoint = null;
	private ActivacionesWS activacionesWS = null;

	public ActivacionesWSProxy() {
		_initActivacionesWSProxy();
	}

	public ActivacionesWSProxy(String endpoint) {
		_endpoint = endpoint;
		_initActivacionesWSProxy();
	}

	private void _initActivacionesWSProxy() {
		try {
			activacionesWS = (new ActivacionesWSServiceLocator()).getActivacionesWSPort();
			if (activacionesWS != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) activacionesWS)._setProperty("javax.xml.rpc.service.endpoint.address",_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) activacionesWS)._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (ServiceException serviceException) {

		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		
		if (activacionesWS != null) {
			((javax.xml.rpc.Stub) activacionesWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
		}

	}

	public ActivacionesWS getActivacionesWS() {
		if (activacionesWS == null)
			_initActivacionesWSProxy();
		
		return activacionesWS;
	}

	public String getSiguienteMidParaActivar() throws RemoteException {
		if (activacionesWS == null) {
			_initActivacionesWSProxy();
		}
		
		return activacionesWS.getSiguienteMidParaActivar();
	}

	public void actualizarDatosActivacion(String mid, String estadoActivacionId) throws RemoteException {
		if (activacionesWS == null) {
			_initActivacionesWSProxy();
		}
		
		activacionesWS.actualizarDatosActivacion(mid, estadoActivacionId);
	}

}