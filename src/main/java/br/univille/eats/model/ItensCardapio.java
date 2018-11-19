package br.univille.eats.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ItensCardapio {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
    private Cardapio cardapio = new Cardapio();
	
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
    private Estabelecimento estabelecimento = new Estabelecimento();
	
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
    private Produto produto = new Produto();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
