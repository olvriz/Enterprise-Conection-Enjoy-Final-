package br.com.fiap.enjoy.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Checkin;
import br.com.fiap.enjoy.domain.Cliente;
import br.com.fiap.enjoy.domain.Estabelecimento;

public class CheckinInserirTest {
	
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			
			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();
			em.getTransaction().begin();
			
			Cliente cliente = new Cliente();
			Estabelecimento estabelecimento = new Estabelecimento();
			cliente.setId(1);
			estabelecimento.setId(1);
			
			Checkin checkin = new Checkin();
			checkin.setCliente(cliente);
			checkin.setEstabelecimento(estabelecimento);
			checkin.setVisita(Calendar.getInstance());			
			
			em.persist(checkin);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
