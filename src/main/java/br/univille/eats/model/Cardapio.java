package br.univille.eats.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cardapio{
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idCardapio;
	@Temporal(value=TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date DataInicio;
	@Temporal(value=TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date DataFim;
    
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
    private Estabelecimento estabelecimento = new Estabelecimento();
	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
    public long getIdCardapio() {
		return idCardapio;
	}
	public void setIdCardapio(long idCardapio) {
		this.idCardapio = idCardapio;
	}
	public Date getDataInicio() {
		return DataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		DataInicio = dataInicio;
	}
	public Date getDataFim() {
		return DataFim;
	}
	public void setDataFim(Date dataFim) {
		DataFim = dataFim;
	}

	
}