package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Cliente;

public class ClienteAlterarTest {
	
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			int idProcurado = 1;
			
			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();
			Cliente cliente = em.find(Cliente.class, idProcurado);
			
			em.getTransaction().begin();
			cliente.setNome("Adarberto - Alterado");
			
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
