package uy.com.amensg.activaciones.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.TipoControl;

@Remote
public interface ITipoControlBean {

	public Collection<TipoControl> list();
}