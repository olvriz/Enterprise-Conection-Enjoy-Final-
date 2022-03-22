package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Cliente;


public class ClienteInserirTest {

	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			
			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();
			em.getTransaction().begin();
			
			Cliente cliente = new Cliente();

			cliente.setCelular(981779987);
			cliente.setNome("Adalberto");
			
			
			em.persist(cliente);
			
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
