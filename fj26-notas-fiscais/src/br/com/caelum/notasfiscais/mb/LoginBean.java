package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario = new Usuario();

	@Inject
	UsuarioDao dao = new UsuarioDao();

	public String efetuaLogin() {
		boolean loginValido = dao.existe(this.usuario);

		if (loginValido) {
			return "produto?faces-redirect=true";
		} else {
			this.usuario = new Usuario();
			return "login";
		}
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
}
