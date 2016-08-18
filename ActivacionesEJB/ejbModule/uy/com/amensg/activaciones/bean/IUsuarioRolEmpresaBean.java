package uy.com.amensg.activaciones.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.Usuario;
import uy.com.amensg.activaciones.entities.UsuarioRolEmpresa;

@Remote
public interface IUsuarioRolEmpresaBean {
	
	public Collection<UsuarioRolEmpresa> listByUsuario(Usuario usuario);
}