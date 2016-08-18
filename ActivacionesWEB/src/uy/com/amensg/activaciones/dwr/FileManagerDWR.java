package uy.com.amensg.activaciones.dwr;

import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.activaciones.bean.FileManagerBean;
import uy.com.amensg.activaciones.bean.IFileManagerBean;
import uy.com.amensg.activaciones.entities.Archivo;
import uy.com.amensg.activaciones.entities.ArchivoTO;

@RemoteProxy
public class FileManagerDWR {

	private IFileManagerBean lookupBean() throws NamingException {
		String EARName = "Activaciones";
		String beanName = FileManagerBean.class.getSimpleName();
		String remoteInterfaceName = IFileManagerBean.class.getName();
		String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
		Context context = new InitialContext();
		
		return (IFileManagerBean) context.lookup(lookupName);
	}
	
	public Collection<ArchivoTO> listArchivos() {
		Collection<ArchivoTO> result = new LinkedList<ArchivoTO>();
		
		try {
			IFileManagerBean iFileManagerBean = lookupBean();
			
			for (Archivo archivo : iFileManagerBean.listArchivos()) {
				result.add(transform(archivo));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static ArchivoTO transform(Archivo archivo) {
		ArchivoTO archivoTO = new ArchivoTO();
		
		archivoTO.setNombre(archivo.getNombre());
		
		return archivoTO;
	}
}