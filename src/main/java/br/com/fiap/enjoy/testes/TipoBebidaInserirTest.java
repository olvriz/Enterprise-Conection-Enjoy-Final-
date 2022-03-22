package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.TipoBebida;

public class TipoBebidaInserirTest {
	
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();
			em.getTransaction().begin();
	
			TipoBebida bebida1 = new TipoBebida(null, "Pilsen");
			em.persist(bebida1);
	
			TipoBebida bebida2 = new TipoBebida(null, "American Ipa");
			em.persist(bebida2);
	
			TipoBebida bebida3 = new TipoBebida(null, "Pale Ale");
			em.persist(bebida3);
	
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null &&  em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
