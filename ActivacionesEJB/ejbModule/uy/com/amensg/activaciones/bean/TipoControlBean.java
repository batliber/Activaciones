package uy.com.amensg.activaciones.bean;

import java.util.Collection;
import java.util.LinkedList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import uy.com.amensg.activaciones.entities.TipoControl;

@Stateless
public class TipoControlBean implements ITipoControlBean {

	@PersistenceContext(unitName = "uy.com.amensg.activaciones.persistenceUnit")
	private EntityManager entityManager;
	
	public Collection<TipoControl> list() {
		Collection<TipoControl> result = new LinkedList<TipoControl>();
		
		try {
			TypedQuery<TipoControl> query = entityManager.createQuery(
				"SELECT t "
				+ " FROM TipoControl t"
				+ " ORDER BY t.descripcion", 
				TipoControl.class
			);
			
			for (TipoControl tipoControl : query.getResultList()) {
				result.add(tipoControl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public TipoControl getById(Long id) {
		TipoControl result = null;
		
		try {
			result = entityManager.find(TipoControl.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}