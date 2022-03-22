package br.com.fiap.enjoy.domain;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_checkin")
public class Checkin {
	
	@Id
	@SequenceGenerator(name = "checkin", sequenceName = "sq_tbl_checkin", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkin")
	@Column(name = "id_checkin")
	private Integer id;
	
	@Column(name = "dt_visita", nullable = false)
	private Calendar visita;
	
	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	@JoinColumn(name = "id_estabelecimento")
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	@OneToMany(mappedBy = "checkin")
	private Collection<Consumo> consumo;

	public Checkin() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getVisita() {
		return visita;
	}

	public void setVisita(Calendar visita) {
		this.visita = visita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Collection<Consumo> getConsumo() {
		return consumo;
	}

	public void setConsumo(Collection<Consumo> consumo) {
		this.consumo = consumo;
	}
}
