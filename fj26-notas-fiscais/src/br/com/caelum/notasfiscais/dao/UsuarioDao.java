package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.notasfiscais.modelo.Usuario;

public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public boolean existe(Usuario usuario) {
		String sqlQuery = "select u from Usuario u where u.login = :pLogin and u.senha = :pSenha";

		Query query = manager.createQuery(sqlQuery)
				.setParameter("pLogin", usuario.getLogin())
				.setParameter("pSenha", usuario.getSenha());
		boolean encontrado = !query.getResultList().isEmpty();
		return encontrado;
	}
}