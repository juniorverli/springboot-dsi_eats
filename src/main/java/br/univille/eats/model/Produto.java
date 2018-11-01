package br.univille.eats.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Produto {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idProd;
	@NotNull
	
	private int quantidade;
	
    @Length(min=2, max=1000, message="O tamanho do nome deve ser entre {min} e {max}")
	private String prod;
	
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
    private Estabelecimento estabelecimento = new Estabelecimento();
	
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
    private Item item = new Item();
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public long getIdProd() {
		return idProd;
	}
	public void setIdProd(long idProd) {
		this.idProd = idProd;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
