package uy.com.amensg.activaciones.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;

import uy.com.amensg.activaciones.robot.util.Configuration;

public class ActivacionesWSServiceLocator extends Service implements ActivacionesWSService {

	private static final long serialVersionUID = 6267614550389305912L;

	private String ActivacionesWSPort_address = Configuration.getInstance().getProperty("ActivacionesWSPort_address");
	private String ActivacionesWSPortWSDDServiceName = "ActivacionesWSPort";
	private HashSet<QName> ports = null;

	public ActivacionesWSServiceLocator() {

	}

	public ActivacionesWSServiceLocator(EngineConfiguration config) {
		super(config);
	}

	public ActivacionesWSServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
		super(wsdlLoc, sName);
	}

	public String getActivacionesWSPortAddress() {
		return ActivacionesWSPort_address;
	}

	public String getActivacionesWSPortWSDDServiceName() {
		return ActivacionesWSPortWSDDServiceName;
	}

	public void setActivacionesWSPortWSDDServiceName(String name) {
		ActivacionesWSPortWSDDServiceName = name;
	}

	public ActivacionesWS getActivacionesWSPort() throws ServiceException {
		URL endpoint;
		try {
			endpoint = new URL(ActivacionesWSPort_address);
		} catch (MalformedURLException e) {
			throw new ServiceException(e);
		}
		return getActivacionesWSPort(endpoint);
	}

	public ActivacionesWS getActivacionesWSPort(URL portAddress) throws ServiceException {
		try {
			ActivacionesWSServiceSoapBindingStub _stub = new ActivacionesWSServiceSoapBindingStub(portAddress, this);
			_stub.setPortName(getActivacionesWSPortWSDDServiceName());
			return _stub;
		} catch (AxisFault e) {
			return null;
		}
	}

	public void setActivacionesWSPortEndpointAddress(String address) {
		ActivacionesWSPort_address = address;
	}

	public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
		try {
			if (ActivacionesWS.class.isAssignableFrom(serviceEndpointInterface)) {
				ActivacionesWSServiceSoapBindingStub _stub = 
					new ActivacionesWSServiceSoapBindingStub(
						new URL(ActivacionesWSPort_address), this
					);
				_stub.setPortName(getActivacionesWSPortWSDDServiceName());
				return _stub;
			}
		} catch (Throwable t) {
			throw new ServiceException(t);
		}
		throw new ServiceException(
			"There is no stub implementation for the interface: "
			+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		
		String inputPortName = portName.getLocalPart();
		
		if ("ActivacionesWSPort".equals(inputPortName)) {
			return getActivacionesWSPort();
		} else {
			Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			
			return _stub;
		}
	}

	public QName getServiceName() {
		return new QName("http://webservices.activaciones.amensg.com.uy/", "ActivacionesWSService");
	}

	public Iterator<QName> getPorts() {
		if (ports == null) {
			ports = new HashSet<QName>();
			ports.add(new QName("http://webservices.activaciones.amensg.com.uy/", "ActivacionesWSPort"));
		}
		return ports.iterator();
	}

	public void setEndpointAddress(String portName, String address) throws ServiceException {
		if ("ActivacionesWSPort".equals(portName)) {
			setActivacionesWSPortEndpointAddress(address);
		} else {
			// Unknown Port Name
			throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	public void setEndpointAddress(QName portName, String address) throws ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}
}