package br.com.fiap.enjoy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_consumo")
public class Consumo {
	
	@Id
	@SequenceGenerator(name = "consumo", sequenceName = "sq_tbl_consumo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumo")
	@Column(name = "id_consumo")
	private Integer id;
	
	@Column(name = "vl_consumo")
	private float valorConsumo;
	
	@JoinColumn(name = "id_tipo_bebida")
	@ManyToOne
	private TipoBebida tipoBebida;
	

	@JoinColumn(name = "id_checkin")
	@ManyToOne
	private Checkin checkin;

	public Consumo() {
		super();
	}

	public Consumo(Integer id, float valorConsumo) {
		super();
		this.id = id;
		this.valorConsumo = valorConsumo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getValorConsumo() {
		return valorConsumo;
	}

	public void setValorConsumo(float valorConsumo) {
		this.valorConsumo = valorConsumo;
	}

	public TipoBebida getTipoBebida() {
		return tipoBebida;
	}

	public void setTipoBebida(TipoBebida tipoBebida) {
		this.tipoBebida = tipoBebida;
	}

	public Checkin getCheckin() {
		return checkin;
	}

	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}
}
