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
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idEstab;
	@NotNull
    @Length(min=1, max=1000, message="O tamanho do nome deve ser entre {min} e {max}")
	private String CNPJ;
    private String CEP;
    private String numero;
    private String telefone;
    private String razao;
    private String bairro;
    private String rua;
    
    @ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
    private Cidade cidade = new Cidade();
    
    
    @ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
    private Pagamento pagamento = new Pagamento();
    
        
	public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
    
	public long getIdEstab() {
		return idEstab;
	}
	public void setIdEstab(long idEstab) {
		this.idEstab = idEstab;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	} 
    
}