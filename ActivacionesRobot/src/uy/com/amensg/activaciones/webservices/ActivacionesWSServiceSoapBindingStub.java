package uy.com.amensg.activaciones.webservices;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;

import org.apache.axis.AxisEngine;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;

public class ActivacionesWSServiceSoapBindingStub extends Stub implements ActivacionesWS {
	
	static OperationDesc[] _operations;

	static {
		_operations = new OperationDesc[2];
		_initOperationDesc1();
	}

	private static void _initOperationDesc1() {
		OperationDesc oper;
		ParameterDesc param;
		oper = new OperationDesc();
		oper.setName("getSiguienteMidParaActivar");
		oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		oper.setReturnClass(String.class);
		oper.setReturnQName(new QName("", "return"));
		oper.setStyle(Style.WRAPPED);
		oper.setUse(Use.LITERAL);
		_operations[0] = oper;

		oper = new OperationDesc();
		oper.setName("actualizarDatosActivacion");
		param = new ParameterDesc(new QName("", "arg0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new ParameterDesc(new QName("", "arg1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(XMLType.AXIS_VOID);
		oper.setStyle(Style.WRAPPED);
		oper.setUse(Use.LITERAL);
		_operations[1] = oper;

	}

	public ActivacionesWSServiceSoapBindingStub() throws AxisFault {
		this(null);
	}

	public ActivacionesWSServiceSoapBindingStub(URL endpointURL, Service service) throws AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public ActivacionesWSServiceSoapBindingStub(Service service) throws AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service).setTypeMappingVersion("1.2");
	}

	protected Call createCall() throws RemoteException {
		try {
			Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			
			Enumeration<Object> keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				 String key = (String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			
			return _call;
		} catch (Throwable _t) {
			throw new AxisFault("Failure trying to get the Call object", _t);
		}
	}

	public String getSiguienteMidParaActivar() throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
		_call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://webservices.activaciones.amensg.com.uy/", "getSiguienteMidParaActivar"));

		setRequestHeaders(_call);
		setAttachments(_call);
		
		try {
			Object _resp = _call.invoke(new Object[] {});

			if (_resp instanceof RemoteException) {
				throw (RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (String) _resp;
				} catch (Exception _exception) {
					return (String) JavaUtils.convert(_resp, String.class);
				}
			}
		} catch (AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void actualizarDatosActivacion(String arg0, String arg1) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		
		Call _call = createCall();
		_call.setOperation(_operations[1]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
		_call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://webservices.activaciones.amensg.com.uy/", "actualizarDatosActivacion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		
		try {
			Object _resp = _call.invoke(new Object[] { arg0, arg1 });

			if (_resp instanceof RemoteException) {
				throw (RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}
}