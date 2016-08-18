package uy.com.amensg.activaciones.bean;

import javax.ejb.Remote;

import uy.com.amensg.activaciones.entities.SeguridadAuditoria;

@Remote
public interface ISeguridadBean {

	public SeguridadAuditoria login(String login, String contrsena);
	
	public void logout(Long usuarioId);

	public void sessionTimeout(Long usuarioId);
}