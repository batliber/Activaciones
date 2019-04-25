package uy.com.amensg.activaciones.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://webservices.logistica.amensg.com.uy/", name = "ActivacionesWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface ActivacionesWebService {

    @WebMethod
    @RequestWrapper(
    	localName = "actualizarDatosActivacion", 
    	targetNamespace = "http://webservices.logistica.amensg.com.uy/", 
    	className = "uy.com.amensg.activaciones.webservices.ActualizarDatosActivacion"
    )
    @ResponseWrapper(
    	localName = "actualizarDatosActivacionResponse", 
    	targetNamespace = "http://webservices.logistica.amensg.com.uy/", 
    	className = "uy.com.amensg.activaciones.webservices.ActualizarDatosActivacionResponse"
    )
    public void actualizarDatosActivacion(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );
    
    @WebMethod
    @RequestWrapper(
    	localName = "getSiguienteMidParaActivar", 
    	targetNamespace = "http://webservices.logistica.amensg.com.uy/", 
    	className = "uy.com.amensg.activaciones.webservices.GetSiguienteMidParaActivar"
    )
    @ResponseWrapper(
    	localName = "getSiguienteMidParaActivarResponse", 
    	targetNamespace = "http://webservices.logistica.amensg.com.uy/", 
    	className = "uy.com.amensg.activaciones.webservices.GetSiguienteMidParaActivarResponse"
    )
    @WebResult(name = "return", targetNamespace = "")
    public String getSiguienteMidParaActivar();
}