package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;



@Named
@RequestScoped
public class ProdutoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();
	private List<Produto> produtos;

	@Inject
	private ProdutoDao dao;

	public Produto getProduto() {
		return this.produto;
	}

	public void gravar() {
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
			produtos = dao.listaTodos();
		return produtos;
	}

	public void remove(Produto produto) {
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getValorTotal() {
		Double total = 0.0;
		for (Produto produto : this.produtos) {
			total += produto.getPreco();
		}
		return total;
	}
}
