package br.com.fiap.enjoy.domain;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

	@Id
	@SequenceGenerator(name = "cliente", sequenceName = "sq_tbl_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	@Column(name = "id_cliente")
	private Integer id;

	@Column(name = "nr_celular", nullable = false)
	private int celular;

	@Column(name = "tx_nome", nullable = false)
	private String nome;

	@Column(name = "tx_cpf")
	private String cpf;

	@Column(name = "tx_genero")
	private char genero;

	@Column(name = "dt_nascimento")
	private Calendar nascimento;

	@Column(name = "tx_cep")
	private String cep;

	@Column(name = "tx_logradouro")
	private String logradouro;

	@Column(name = "tx_numero_casa")
	private String numero;

	@Column(name = "tx_bairro")
	private String bairro;

	@Column(name = "tx_cidade")
	private String cidade;

	@Column(name = "tx_uf")
	private char uf;
	
	@OneToMany(mappedBy = "cliente")
	private Collection<Checkin> checkin;

	public Cliente() {
		super();
	}

	
	public Cliente(Integer id, int celular, String nome, String cpf, char genero, Calendar nascimento, String cep,
		String logradouro, String numero, String bairro, String cidade, char uf) {
		super();
		this.id = id;
		this.celular = celular;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.nascimento = nascimento;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getCelular() {
		return celular;
	}


	public void setCelular(int celular) {
		this.celular = celular;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public char getGenero() {
		return genero;
	}


	public void setGenero(char genero) {
		this.genero = genero;
	}


	public Calendar getNascimento() {
		return nascimento;
	}


	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public char getUf() {
		return uf;
	}


	public void setUf(char uf) {
		this.uf = uf;
	}


	public Collection<Checkin> getCheckin() {
		return checkin;
	}


	public void setCheckin(Collection<Checkin> checkin) {
		this.checkin = checkin;
	}
}
