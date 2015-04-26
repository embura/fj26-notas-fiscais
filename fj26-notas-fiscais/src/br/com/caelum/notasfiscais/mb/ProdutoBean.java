package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<Produto> produtos;

	public Produto getProduto() {
		return this.produto;
	}

	public void gravar() {

		System.out.println("Será que vai passar aqui ?");
		ProdutoDao dao = new ProdutoDao();

		if (this.produto.getId() == null) {
			dao.adiciona(this.produto);
		} else {
			dao.atualiza(this.produto);
		}

		this.produtos = dao.listaTodos();
		this.produto = new Produto();
	}

	public List<Produto> getProdutos() {
		if (produtos == null)
			produtos = new ProdutoDao().listaTodos();
		return produtos;
	}

	public void remove(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
