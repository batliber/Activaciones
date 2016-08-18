package uy.com.amensg.activaciones.webservices;

import java.net.URL;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface ActivacionesWSService extends Service {
    
	public String getActivacionesWSPortAddress();

    public ActivacionesWS getActivacionesWSPort() throws ServiceException;

    public ActivacionesWS getActivacionesWSPort(URL portAddress) throws ServiceException;
}