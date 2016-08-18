package uy.com.amensg.activaciones.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.TipoActivacion;

@Remote
public interface ITipoActivacionBean {

	public Collection<TipoActivacion> list();
}