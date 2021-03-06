package uy.com.amensg.activaciones.bean;

import java.util.Collection;
import java.util.LinkedList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import uy.com.amensg.activaciones.entities.TipoActivacion;

@Stateless
public class TipoActivacionBean implements ITipoActivacionBean {

	@PersistenceContext(unitName = "uy.com.amensg.activaciones.persistenceUnit")
	private EntityManager entityManager;
	
	public Collection<TipoActivacion> list() {
		Collection<TipoActivacion> result = new LinkedList<TipoActivacion>();
		
		try {
			TypedQuery<TipoActivacion> query = entityManager.createQuery(
				"SELECT t "
				+ " FROM TipoActivacion t"
				+ " ORDER BY t.descripcion", 
				TipoActivacion.class
			);
			
			for (TipoActivacion tipoActivacion : query.getResultList()) {
				result.add(tipoActivacion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public TipoActivacion getById(Long id) {
		TipoActivacion result = null;
		
		try {
			result = entityManager.find(TipoActivacion.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}