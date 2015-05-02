package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// testar inject
	@Inject
	private Usuario usuario;// = new Usuario();

	@Inject
	private UsuarioLogadoBean usuarioLogado;

	@Inject
	private UsuarioDao dao;

	public String efetuaLogin() {
		boolean loginValido = dao.existe(this.usuario);

		if (loginValido) {
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true";
		} else {
			usuarioLogado.desloga();
			this.usuario = new Usuario();
			return "login";
		}
	}

	public String logout() {
		usuarioLogado.desloga();
		this.usuario = new Usuario();
		return "login";
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
}
