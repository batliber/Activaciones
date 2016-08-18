package uy.com.amensg.activaciones.bean;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.amensg.activaciones.entities.SeguridadAuditoria;
import uy.com.amensg.activaciones.entities.SeguridadTipoEvento;
import uy.com.amensg.activaciones.entities.Usuario;
import uy.com.amensg.activaciones.util.Configuration;
import uy.com.amensg.activaciones.util.MD5Utils;

@Stateless
public class SeguridadBean implements ISeguridadBean {

	@PersistenceContext(unitName = "uy.com.amensg.activaciones.persistenceUnit")
	private EntityManager entityManager;
	
	@EJB
	private IUsuarioBean iUsuarioBean;
	
	@EJB
	private ISeguridadAuditoriaBean iSeguridadAuditoriaBean;
	
	public SeguridadAuditoria login(String login, String contrasena) {
		SeguridadAuditoria result = null;
		
		try {
			Usuario usuario = iUsuarioBean.getByLogin(login);
			
			if ((usuario != null) && (usuario.getContrasena().equals(MD5Utils.stringToMD5(contrasena)))) {
				Date date = GregorianCalendar.getInstance().getTime();
				
				SeguridadAuditoria seguridadAuditoria = new SeguridadAuditoria();
				seguridadAuditoria.setFecha(date);
				
				SeguridadTipoEvento seguridadTipoEvento = new SeguridadTipoEvento();
				seguridadTipoEvento.setId(
					new Long(Configuration.getInstance().getProperty("seguridadTipoEvento.Login"))
				);
				
				seguridadAuditoria.setSeguridadTipoEvento(seguridadTipoEvento);
				
				seguridadAuditoria.setUsuario(usuario);
				
				seguridadAuditoria.setFact(date);
				seguridadAuditoria.setTerm(new Long(1));
				seguridadAuditoria.setUact(usuario.getId());
				
				entityManager.persist(seguridadAuditoria);
				
				result = seguridadAuditoria;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void logout(Long usuarioId) {
		try {
			Date date = GregorianCalendar.getInstance().getTime();
			
			Usuario usuario = iUsuarioBean.getById(usuarioId);
			
			SeguridadAuditoria seguridadAuditoria = new SeguridadAuditoria();
			seguridadAuditoria.setFecha(date);
			
			SeguridadTipoEvento seguridadTipoEvento = new SeguridadTipoEvento();
			seguridadTipoEvento.setId(
				new Long(Configuration.getInstance().getProperty("seguridadTipoEvento.Logout"))
			);
			
			seguridadAuditoria.setSeguridadTipoEvento(seguridadTipoEvento);
			
			seguridadAuditoria.setUsuario(usuario);
			
			seguridadAuditoria.setFact(date);
			seguridadAuditoria.setTerm(new Long(1));
			seguridadAuditoria.setUact(usuario.getId());
			
			entityManager.persist(seguridadAuditoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sessionTimeout(Long usuarioId) {
		try {
			Date date = GregorianCalendar.getInstance().getTime();
			
			Usuario usuario = iUsuarioBean.getById(usuarioId);
			
			SeguridadAuditoria seguridadAuditoria = new SeguridadAuditoria();
			seguridadAuditoria.setFecha(date);
			
			SeguridadTipoEvento seguridadTipoEvento = new SeguridadTipoEvento();
			seguridadTipoEvento.setId(
				new Long(Configuration.getInstance().getProperty("seguridadTipoEvento.Timeout"))
			);
			
			seguridadAuditoria.setSeguridadTipoEvento(seguridadTipoEvento);
			
			seguridadAuditoria.setUsuario(usuario);
			
			seguridadAuditoria.setFact(date);
			seguridadAuditoria.setTerm(new Long(1));
			seguridadAuditoria.setUact(usuario.getId());
			
			entityManager.persist(seguridadAuditoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}