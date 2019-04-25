package uy.com.amensg.activaciones.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _ActualizarDatosActivacion_QNAME = new QName("http://webservices.logistica.amensg.com.uy/", "actualizarDatosActivacion");
    private final static QName _ActualizarDatosActivacionResponse_QNAME = new QName("http://webservices.logistica.amensg.com.uy/", "actualizarDatosActivacionResponse");
    private final static QName _GetSiguienteMidParaActivar_QNAME = new QName("http://webservices.logistica.amensg.com.uy/", "getSiguienteMidParaActivar");
    private final static QName _GetSiguienteMidParaActivarResponse_QNAME = new QName("http://webservices.logistica.amensg.com.uy/", "getSiguienteMidParaActivarResponse");

    public ObjectFactory() {
    	
    }

    public ActualizarDatosActivacion createActualizarDatosActivacion() {
        return new ActualizarDatosActivacion();
    }

    public ActualizarDatosActivacionResponse createActualizarDatosActivacionResponse() {
        return new ActualizarDatosActivacionResponse();
    }
    
    public GetSiguienteMidParaActivar createGetSiguienteMidParaActivar() {
        return new GetSiguienteMidParaActivar();
    }

    public GetSiguienteMidParaActivarResponse createGetSiguienteMidParaActivarResponse() {
        return new GetSiguienteMidParaActivarResponse();
    }

    @XmlElementDecl(namespace = "http://webservices.logistica.amensg.com.uy/", name = "actualizarDatosActivacion")
    public JAXBElement<ActualizarDatosActivacion> createActualizarDatosActivacion(ActualizarDatosActivacion value) {
        return new JAXBElement<ActualizarDatosActivacion>(_ActualizarDatosActivacion_QNAME, ActualizarDatosActivacion.class, null, value);
    }

    @XmlElementDecl(namespace = "http://webservices.logistica.amensg.com.uy/", name = "actualizarDatosActivacionResponse")
    public JAXBElement<ActualizarDatosActivacionResponse> createActualizarDatosActivacionResponse(ActualizarDatosActivacionResponse value) {
        return new JAXBElement<ActualizarDatosActivacionResponse>(_ActualizarDatosActivacionResponse_QNAME, ActualizarDatosActivacionResponse.class, null, value);
    }
    
    @XmlElementDecl(namespace = "http://webservices.logistica.amensg.com.uy/", name = "getSiguienteMidParaActivar")
    public JAXBElement<GetSiguienteMidParaActivar> createGetSiguienteMidParaActivar(GetSiguienteMidParaActivar value) {
        return new JAXBElement<GetSiguienteMidParaActivar>(_GetSiguienteMidParaActivar_QNAME, GetSiguienteMidParaActivar.class, null, value);
    }

    @XmlElementDecl(namespace = "http://webservices.logistica.amensg.com.uy/", name = "getSiguienteMidParaActivarResponse")
    public JAXBElement<GetSiguienteMidParaActivarResponse> createGetSiguienteMidParaActivarResponse(GetSiguienteMidParaActivarResponse value) {
        return new JAXBElement<GetSiguienteMidParaActivarResponse>(_GetSiguienteMidParaActivarResponse_QNAME, GetSiguienteMidParaActivarResponse.class, null, value);
    }
}