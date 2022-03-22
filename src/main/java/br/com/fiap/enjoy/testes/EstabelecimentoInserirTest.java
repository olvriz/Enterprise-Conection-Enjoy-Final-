package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Estabelecimento;

public class EstabelecimentoInserirTest {
	
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();
			em.getTransaction().begin();
			
			Estabelecimento estabelecimento1 = new Estabelecimento(null, "Tenda da Barra");
			em.persist(estabelecimento1);
			
			Estabelecimento estabelecimento2 = new Estabelecimento(null, "Adega do Zé");
			em.persist(estabelecimento2);
			
			Estabelecimento estabelecimento3 = new Estabelecimento(null, "Bora bebe");
			em.persist(estabelecimento3);
			
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
