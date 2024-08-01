package step04.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.OneToMany;

import org.junit.Test;

import util.DBUtil;

public class Step04RunTest {

	//step03
	//중요: 멤버 기준으로 팀 정보 확인
	//부모테이블 Team, 자식테이블 Member
	@Test
	public void step03Test() {
		EntityManager em = DBUtil.getEntityManager();
		
		Member4 member = em.find(Member4.class, 1L);
		System.out.println(1);
		System.out.println(member.getName());
		System.out.println(2);
		System.out.println(member.getTeamId().getTeamName());
		
		em.close();
		em = null;
	}
	
	
	//step02 - 이미 존재하는 table과 데이터가 있다는 가정 하의 실습
	//중요: 팀 정보 기준으로 멤버 정보 확인
	//persistence.xml에서 create->none으로 설정 후 진행
	//select -> transaction 불필요
	//@Test
	public void step02Test() {
		EntityManager em = DBUtil.getEntityManager();
		
		//실습1: team 검색
		/*
		 * Team4: @OneToMany(mappedBy = "teamId")
		 * Member4: @OneToOne
		 */
		
		/*
		 1은 정수(int, 32bits), Team4의 pk 변수는 long(64bits)
		 
		 int -> long으로 자동 형변환 (기본 타입의 기질)
		 Integer와 Long 객체타입 간의 자동 형변환 불가 (객체 타입의 자동 형변환은 상속 관계에서만 가능)
		 
		 1 -> new Integer(1): autoboxing 자동 변환
		 문제는 Integer가 아닌 Long 타입 필요 -> 따라서 Long객체로 변환 가능한 값 표현
		 long 값 표현시 l or L 붙이기
		 */
		//Team4 team = em.find(Team4.class, 1); //junit error
		Team4 team = em.find(Team4.class, 1L);
		System.out.println(team.getTeamName());
		
		
		//실습2: 팀에 소속된 팀원명 검색 (팀 정보 기준으로 멤버 정보 확인)
		List<Member4> all = team.getMembers(); //이미 알고있는 team_id 값으로 member table을 검색
		System.out.println(all.get(0).getName());
		System.out.println(all.get(1).getName());
		
		
		//실습3: Member4의 @OneToOne -> @ManyToOne으로 변경
		
		
		em.close();
		em = null;
	}
	
	
	//step01 - 데이터 저장만
	//@Test
	public void step01Test() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Team4 t1 = new Team4("축구1팀");
			em.persist(t1);
			em.persist(new Team4("배구1팀"));
			
			em.persist(new Member4("손흥민", t1));  
			em.persist(new Member4("김연경", t1));  
			em.persist(new Member4("박찬호", t1));  
			
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

