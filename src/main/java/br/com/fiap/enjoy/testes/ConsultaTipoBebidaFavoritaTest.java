package br.com.fiap.enjoy.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Query;

public class ConsultaTipoBebidaFavoritaTest {
	
public static void main(String[] args) {
		
		EntityManager em = null;
		
		try {
			int idProcurado = 1;

			em = Persistence.createEntityManagerFactory("enjoy").createEntityManager();			
			String sql = "SELECT tibe.tx_decricao FROM tbl_consumo cons INNER JOIN tbl_tipo_bebida tibe ON tibe.id_tipo_bebida = cons.id_tipo_bebida INNER JOIN tbl_checkin chec ON chec.id_checkin = cons.id_checkin WHERE chec.id_cliente = " + idProcurado + " AND ROWNUM = 1 GROUP BY tibe.tx_decricao ORDER BY COUNT(0)";
			Query q = (Query) em.createNativeQuery(sql);
			
			List<String> test = q.getResultList();

			for (String checkin : test) {
			    System.out.println("Tipo de bebida favorita " + checkin);
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
