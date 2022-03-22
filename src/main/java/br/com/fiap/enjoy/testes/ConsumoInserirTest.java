package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Checkin;
import br.com.fiap.enjoy.domain.Consumo;
import br.com.fiap.enjoy.domain.TipoBebida;

public class ConsumoInserirTest {
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			
			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();
			em.getTransaction().begin();
			
			Checkin checkin = new Checkin();
			TipoBebida bebida = new TipoBebida();
			checkin.setId(1);
			bebida.setId(1);
			
			Consumo consumo = new Consumo();
			consumo.setValorConsumo(15);	
			consumo.setCheckin(checkin);
			consumo.setTipoBebida(bebida);
			
			em.persist(consumo);
			
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
