package com.hibernate.utiles;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.hibernate.components.ConectorJPA;
import com.hibernate.entities.Usuario;
import com.hibernate.interfaces.DAO;

public class Util implements DAO<Usuario, String> {

	//private final String KEY = "JavaWebAPI";

	public Util() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario buscar(String correo) {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		var conector = new ConectorJPA();
		EntityManager em = conector.getEntityManager();
		TypedQuery<Usuario> query = em.createQuery(
				"select u from Usuario u where u.correo = :email",
				Usuario.class);
		//query.setParameter("pwd", KEY);
		query.setParameter("email", correo);
		usuario = query.getSingleResult();
		return usuario;
		/*
		 * var conector = new ConectorJPA(); EntityManager em =
		 * conector.getEntityManager(); Usuario u = em.find(Usuario.class, correo);
		 * return u;
		 */
	}

	@Override
	public void eliminar(Usuario usuario) {
		// TODO Auto-generated method stub
		//Usuario u = null;
		var conector = new ConectorJPA();
		EntityManager em = conector.getEntityManager();
		Usuario u = em.find(Usuario.class, usuario.getCorreo());
		//u = buscar(usuario.getCorreo());
		EntityTransaction  tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(u);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage() + " No existe la entidad");
		}
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		var conector = new ConectorJPA();
		EntityManager em = conector.getEntityManager();
		var tx = em.getTransaction();
		tx.begin();
		em.merge(usuario);
		tx.commit();
		//OTRA FORMA
		/*try {
			tx.begin();
			em.persist(usuario);	
			tx.commit();
		} catch (PersistenceException  e) {
			tx.rollback();
			System.out.println(e.getMessage()+ " Clave duplicada, usuario ya existe");
		}*/


	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		var conector = new ConectorJPA();
		EntityManager em = conector.getEntityManager();
		var strJPQL = new StringBuilder().append("SELECT u FROM Usuario u").toString();
		var query = em.createQuery(strJPQL);
		List<Usuario> listUsuarios = query.getResultList();
		return listUsuarios;
	}

}
