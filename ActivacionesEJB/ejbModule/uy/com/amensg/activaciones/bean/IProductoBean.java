package uy.com.amensg.activaciones.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.Producto;

@Remote
public interface IProductoBean {

	public Collection<Producto> list();
	
	public Producto getById(Long id);
	
	public void save(Producto producto);
	
	public void remove(Producto producto);
	
	public void update(Producto producto);
}