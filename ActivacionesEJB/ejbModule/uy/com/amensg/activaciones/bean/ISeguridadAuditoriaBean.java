package uy.com.amensg.activaciones.bean;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.SeguridadAuditoria;

@Remote
public interface ISeguridadAuditoriaBean {

	public void save(SeguridadAuditoria seguridadAuditoria);
}