package br.com.fiap.enjoy.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Query;

public class ConsultaTicketMedioTest {
	
	public static void main(String[] args) {
		
		EntityManager em = null;
		
		try {
			int idProcurado = 1;

			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();			
			String sql = "SELECT AVG(cons.vl_consumo) FROM tbl_consumo cons INNER JOIN tbl_checkin chec ON chec.id_checkin = cons.id_checkin WHERE chec.id_estabelecimento = " + idProcurado;
			Query q = (Query) em.createNativeQuery(sql);
			
			List<BigDecimal> test = q.getResultList();

			for (BigDecimal checkin : test) {
			    System.out.println("Ticket médio R$ " + checkin);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
