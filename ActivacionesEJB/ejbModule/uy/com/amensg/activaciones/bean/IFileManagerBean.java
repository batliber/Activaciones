package uy.com.amensg.activaciones.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.Archivo;

@Remote
public interface IFileManagerBean {

	public Collection<Archivo> listArchivos();
}