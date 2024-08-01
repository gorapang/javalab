package step11_myArt;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import util.DBUtil;

public class RunTest {

	@Test
	public void step01Test() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Dept d1 = new Dept(11L, "부서이름","위치");
			em.persist(d1);
			Emp e1 = new Emp(123L, "이름","직업",11L, new Date(0), 11L, 11L, d1);
			System.out.println(e1);
			em.persist(e1);
			
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
				em = null;
			}
		}
		
	}
}
