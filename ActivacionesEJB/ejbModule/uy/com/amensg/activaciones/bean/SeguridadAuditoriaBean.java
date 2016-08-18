package uy.com.amensg.activaciones.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.amensg.activaciones.entities.SeguridadAuditoria;

@Stateless
public class SeguridadAuditoriaBean implements ISeguridadAuditoriaBean {

	@PersistenceContext(unitName = "uy.com.amensg.activaciones.persistenceUnit")
	private EntityManager entityManager;
	
	public void save(SeguridadAuditoria seguridadAuditoria) {
		try {
			entityManager.persist(seguridadAuditoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}