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
@Table(name = "tbl_estabelecimento")
public class Estabelecimento {
	
	@Id
	@SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tbl_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento")
	@Column(name = "id_estabelecimento")
	private Integer id;
	
	@Column(name = "tx_nome", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "estabelecimento")
	private Collection<Checkin> checkin;

	public Estabelecimento() {
		super();
	}

	public Estabelecimento(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Checkin> getCheckin() {
		return checkin;
	}

	public void setCheckin(Collection<Checkin> checkin) {
		this.checkin = checkin;
	}
}
