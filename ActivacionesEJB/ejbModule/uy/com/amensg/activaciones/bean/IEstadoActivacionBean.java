package uy.com.amensg.activaciones.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.EstadoActivacion;

@Remote
public interface IEstadoActivacionBean {

	public Collection<EstadoActivacion> list();
	
	public EstadoActivacion getById(Long id);
}