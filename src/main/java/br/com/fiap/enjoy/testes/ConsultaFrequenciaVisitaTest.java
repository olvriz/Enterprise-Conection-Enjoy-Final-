package br.com.fiap.enjoy.testes;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Query;

public class ConsultaFrequenciaVisitaTest {
	
	public static void main(String[] args) {
		
		EntityManager em = null;
		
		try {
			int idProcurado = 1;

			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();			
			String sql = "SELECT COUNT(0) AS Frequencia FROM tbl_checkin  WHERE id_cliente = " + idProcurado;
			Query q = (Query) em.createNativeQuery(sql);
			
			List<BigDecimal> test = q.getResultList();

			for (BigDecimal checkin : test) {
			    System.out.println("Frequência de visita: " + checkin);
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
