package br.com.fiap.enjoy.testes;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.hibernate.Query;


public class ConsultaUltimaVisitaTest {

	public static void main(String[] args) {
		
		EntityManager em = null;
		
		try {
			int idProcurado = 1;

			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();			
			String sql = "SELECT dt_visita FROM tbl_checkin  WHERE ROWNUM = 1 AND id_cliente = " + idProcurado + " ORDER BY dt_visita DESC";
			Query q = (Query) em.createNativeQuery(sql);
			
			List<Timestamp> test = q.getResultList();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			for (Timestamp checkin : test) {
			    System.out.println("Data última visita " + df.format(checkin));
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
