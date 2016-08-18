package uy.com.amensg.activaciones.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.Rol;

@Remote
public interface IRolBean {

	public Collection<Rol> list();
	
	public Rol getById(Long id);
}