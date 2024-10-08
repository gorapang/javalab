package running;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import model.domain.entity.Customer;
import model.domain.entity.Dept;
import util.DBUtil;

public class RunningTest {
	
	//step04: dept entity 개발 -> 설정 파일에 등록 -> 모든 부서 검색해서 출력
	/*
	 * JPA만의 select 문장 
	 * - JPA는 entity를 기반으로 rdbms의 table과 소통
	 * - select 엔티티멘버변수들 from entity명
	 * - select d from Dept d;
	 * - Dept entity의 모든 내용 검색 (모든 멤버 변수)
	 * 	: rdbms로 select * from dept
	 * 	
	 * select dname from dept; -> JPA의 select 문장으로 변환 시
	 * select d.dname from Dept d;
	 * d: 참조 변수로 간주
	 * d.dname: d가 참조하는 객체의 dname 멤버 변수명 호출
	 * 
	 */
	@Test
	public void step04() {
		EntityManager em = DBUtil.getEntityManager();
		//EntityTransaction tx = em.getTransaction(); //select 시 필요 없음
		List<Dept> data = em.createQuery("select d from Dept d", Dept.class).getResultList();	
		System.out.println(data.size());
		
		//stream api + lambda식으로 출력
		
	    data.stream().forEach(dept -> {
	        System.out.print("Deptno: " + dept.getDeptno() + " | ");
	        System.out.print("DName: " + dept.getDname()+ " | ");
	        System.out.println("Loc: " + dept.getLoc());
	    });
		
	    System.out.println();
	    
	    data.forEach(System.out::println);
	    
	    //?모든 부서번호의 합
	    int deptnoSum = em.createQuery("select d from Dept d", Dept.class).getResultStream().mapToInt(Dept::getDeptno).sum();
	    System.out.println("모든 부서번호의 합: " + deptnoSum);
	    
	    //?부서번호가 40 미만인 부서번호들만 합을 구하기
	    int oversum = em.createQuery("select d from Dept d", Dept.class)
	    		.getResultStream()
	    		.mapToInt(Dept::getDeptno)
	    		.filter(deptno -> deptno < 40)
	    		.sum();
	    System.out.println("40미만 합: " + oversum);
		em.close();
	}
	
	
	//step03 : 존재하는 customer table 검색 -> 수정 -> 검색 -> 삭제
	//@Test
	public void step03() {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Customer c = em.find(Customer.class, 9); //select
		System.out.println(c);

		c = em.find(Customer.class, 9); //non-select
		System.out.println(c);
		
		tx.begin();
		
		c.setAge(20); //update 준비(DB에 영구 적용 직전, 영속성 영역에 이미 반영)
		em.remove(c); //delete 준비(DB에 영구 적용 직전, 영속성 영역에 이미 반영) persistence context의 내용도 삭제 의미 + delete 문장 생성
		
		//em.clear();
		c = em.find(Customer.class, 9); // select?
		System.out.println(c); // commit()시: null, non-commit()시: null
		
		tx.commit(); //실제 db에 update와 delete 수행
		
		em.close();
	}
	
	
	
	//step02: 저장 시도는 하나 commit 안함. 검색, 단 setXxx 메소드로 값 수정 시도
	//@Test
	public void step02() {
		
		EntityManager em = DBUtil.getEntityManager();

		em.persist(new Customer("id2", "연아", 50)); 
			
		Customer c1 = em.find(Customer.class, 1); //no가 2인 데이터 검색
		System.out.println("-1- " + c1); // -1- null
		
		c1.setName("박지오");
		System.out.println("-2- " + c1);
		
		
		c1 = em.find(Customer.class, 10);
		System.out.println("-3- " + c1);
		em.close();
	}

	
	
	//step01: insert, select
	//@Test
	public void step01() {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new Customer("id1", "연아", 50)); //no가 1로 저장되어 있음
		
		//Customer c1 = em.find(Customer.class, 1);
		//System.out.println(c1);
		
		//c1.setName("유다연");
		tx.commit(); 
	
		em.close();
	}
}


