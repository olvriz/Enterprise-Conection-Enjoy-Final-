package br.com.fiap.enjoy.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_bebida")
public class TipoBebida {
	
	@Id
	@SequenceGenerator(name = "tipo_bebida", sequenceName = "sq_tbl_tipo_bebida", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_bebida")
	@Column(name = "id_tipo_bebida")
	private Integer id;
	
	@Column(name = "tx_decricao", nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "tipoBebida")
	private Collection<Consumo> consumo;

	public TipoBebida() {
		super();
	}

	public TipoBebida(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Consumo> getConsumo() {
		return consumo;
	}

	public void setConsumo(Collection<Consumo> consumo) {
		this.consumo = consumo;
	}
}
