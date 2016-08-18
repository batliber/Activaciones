package uy.com.amensg.activaciones.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.EstadoControl;

@Remote
public interface IEstadoControlBean {

	public Collection<EstadoControl> list();
	
	public EstadoControl getById(Long id);
}