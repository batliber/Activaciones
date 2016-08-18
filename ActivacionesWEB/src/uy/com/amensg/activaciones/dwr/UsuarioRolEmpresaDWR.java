package uy.com.amensg.activaciones.dwr;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.activaciones.entities.Empresa;
import uy.com.amensg.activaciones.entities.EmpresaTO;
import uy.com.amensg.activaciones.entities.Rol;
import uy.com.amensg.activaciones.entities.Usuario;
import uy.com.amensg.activaciones.entities.UsuarioRolEmpresa;
import uy.com.amensg.activaciones.entities.UsuarioRolEmpresaTO;
import uy.com.amensg.activaciones.entities.UsuarioTO;

@RemoteProxy
public class UsuarioRolEmpresaDWR {

	public Collection<EmpresaTO> listEmpresasByContext() {
		Collection<EmpresaTO> result = new LinkedList<EmpresaTO>();
		
		try {
			HttpSession httpSession = WebContextFactory.get().getSession(false);
			
			if ((httpSession != null) && (httpSession.getAttribute("sesion") != null)) {
				Long usuarioId = (Long) httpSession.getAttribute("sesion");
				
				UsuarioTO usuario = new UsuarioDWR().getById(usuarioId);
				
				Map<Long, EmpresaTO> empresas = new HashMap<Long, EmpresaTO>();
				for (UsuarioRolEmpresaTO usuarioRolEmpresaTO : usuario.getUsuarioRolEmpresas()) {
					empresas.put(
						usuarioRolEmpresaTO.getEmpresa().getId(), 
						usuarioRolEmpresaTO.getEmpresa()
					);
				}
				
				List<EmpresaTO> toOrder = new LinkedList<EmpresaTO>();
				toOrder.addAll(empresas.values());
				
				Collections.sort(toOrder, new Comparator<EmpresaTO>() {
					public int compare(EmpresaTO o1, EmpresaTO o2) {
						return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
					}					
				});
				
				result.addAll(toOrder);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static UsuarioRolEmpresaTO transform(UsuarioRolEmpresa usuarioRolEmpresa) {
		UsuarioRolEmpresaTO usuarioRolEmpresaTO = new UsuarioRolEmpresaTO();
		
		usuarioRolEmpresaTO.setEmpresa(EmpresaDWR.transform(usuarioRolEmpresa.getEmpresa()));
		usuarioRolEmpresaTO.setRol(RolDWR.transform(usuarioRolEmpresa.getRol()));
		
		usuarioRolEmpresaTO.setFact(usuarioRolEmpresa.getFact());
		usuarioRolEmpresaTO.setId(usuarioRolEmpresa.getId());
		usuarioRolEmpresaTO.setTerm(usuarioRolEmpresa.getTerm());
		usuarioRolEmpresaTO.setUact(usuarioRolEmpresa.getUact());
		
		return usuarioRolEmpresaTO;
	}
	
	public static UsuarioRolEmpresa transform(UsuarioRolEmpresaTO usuarioRolEmpresaTO) {
		UsuarioRolEmpresa usuarioRolEmpresa = new UsuarioRolEmpresa();
		
		Empresa empresa = new Empresa();
		empresa.setId(usuarioRolEmpresaTO.getEmpresa().getId());
		
		usuarioRolEmpresa.setEmpresa(empresa);
		
		Rol rol = new Rol();
		rol.setId(usuarioRolEmpresaTO.getRol().getId());
		
		usuarioRolEmpresa.setRol(rol);
		
		if (usuarioRolEmpresaTO.getUsuario() != null) {
			Usuario usuario = new Usuario();
			usuario.setId(usuarioRolEmpresaTO.getUsuario().getId());
			
			usuarioRolEmpresa.setUsuario(usuario);
		}
		
		usuarioRolEmpresa.setFact(usuarioRolEmpresaTO.getFact());
		usuarioRolEmpresa.setId(usuarioRolEmpresaTO.getId());
		usuarioRolEmpresa.setTerm(usuarioRolEmpresaTO.getTerm());
		usuarioRolEmpresa.setUact(usuarioRolEmpresaTO.getUact());
		
		return usuarioRolEmpresa;
	}
}

class ComparatorUsuarioTO implements Comparator<UsuarioTO> {
	
	public ComparatorUsuarioTO() {
		
	}
	
	public int compare(UsuarioTO o1, UsuarioTO o2) {
		return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
	}	
}