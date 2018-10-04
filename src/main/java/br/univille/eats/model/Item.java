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
public class Item {
		
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private long idItem;
		@NotNull
		
		private int quantidade;
		
	    //@Length(min=2, max=1000, message="O tamanho do nome deve ser entre {min} e {max}")
		private String nome;
		
		
		@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
	    private Estabelecimento estabelecimento = new Estabelecimento();
		
		public Estabelecimento getEstabelecimento() {
			return estabelecimento;
		}
		public void setEstabelecimento(Estabelecimento estabelecimento) {
			this.estabelecimento = estabelecimento;
		}
		
		public long getIdItem() {
			return idItem;
		}
		public void setIdItem(long idItem) {
			this.idItem = idItem;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
}
