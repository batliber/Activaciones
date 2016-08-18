package uy.com.amensg.activaciones.bean;

import java.util.Collection;
import java.util.LinkedList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import uy.com.amensg.activaciones.entities.Empresa;
import uy.com.amensg.activaciones.entities.Rol;
import uy.com.amensg.activaciones.entities.Usuario;
import uy.com.amensg.activaciones.entities.UsuarioRolEmpresa;

@Stateless
public class UsuarioRolEmpresaBean implements IUsuarioRolEmpresaBean {

	@PersistenceContext(unitName = "uy.com.amensg.activaciones.persistenceUnit")
	private EntityManager entityManager;
	
	@EJB
	private IUsuarioBean iUsuarioBean;
	
	@EJB
	private IRolBean iRolBean;
	
	public Collection<UsuarioRolEmpresa> listByUsuario(Usuario usuario) {
		Collection<UsuarioRolEmpresa> result = new LinkedList<UsuarioRolEmpresa>();
		
		return result;
	}
	
	public Collection<UsuarioRolEmpresa> listByRolUsuario(Rol rol, Usuario usuario) {
		Collection<UsuarioRolEmpresa> result = new LinkedList<UsuarioRolEmpresa>();
		
		try {
			Usuario usuarioManaged = iUsuarioBean.getById(usuario.getId());
			
			Collection<Empresa> empresas = new LinkedList<Empresa>();
			for (UsuarioRolEmpresa usuarioRolEmpresa : usuarioManaged.getUsuarioRolEmpresas()) {
				empresas.add(usuarioRolEmpresa.getEmpresa());
			}
			
			TypedQuery<UsuarioRolEmpresa> query = entityManager.createQuery(
				"SELECT ure"
				+ " FROM UsuarioRolEmpresa ure"
				+ " WHERE ure.rol = :rol"
				+ " AND ure.empresa IN :empresas"
				+ " AND ure.usuario.fechaBaja IS NULL"
				+ " ORDER BY ure.usuario.nombre ASC",
				UsuarioRolEmpresa.class
			);
			query.setParameter("rol", rol);
			query.setParameter("empresas", empresas);
			
			for (UsuarioRolEmpresa usuarioRolEmpresaResult : query.getResultList()) {
				result.add(usuarioRolEmpresaResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}