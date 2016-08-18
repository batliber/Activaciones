package uy.com.amensg.activaciones.dwr;

import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.activaciones.util.Configuration;

@RemoteProxy
public class ConfigurationDWR {

	public String getProperty(String name) {
		return Configuration.getInstance().getProperty(name);
	}
}