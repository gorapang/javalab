/*
spring data jpa
- sql문장 직접 개발하지 않음
- db 설정 정보는 application.properties에 저장
- library 세팅 완료
- 비즈로직 지정
- 개발 기술
	어떤 table/pk
	서비스 기능의 메소드 제시
 */


package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ce.fisa.model.entity.Emp2;
import java.util.List;


@Repository //=@Component와 같지만 DAO임을 알려줌
public interface Emp2Repository extends JpaRepository<Emp2, Integer>{
	
	//사번(empno)로 이름 검색? 상속 안함 즉 우리가 개발

	//select * from emp2 where ename='SMITH';
	//find ename by emp2
	//List<Emp2> findByEname(String ename);
	public Emp2 findByEname(String ename); //DAO method: 서비스에서 호출
	
	
	/*
	사번으로 부서번호 수정 메소드도 우리가 개발
	update emp2 set deptno=? where empno=?
		-동적바인딩
		:? or :변수명
	
	필요 데이터: 사번, 갱신용 부서번호
	insert/update/delete 후 반드시 commit or rollback - 트랜잭션 처리
	
	sql 문장으로 개발 기술 학습 - 단, table명 기준이 아니라 entity명 기준
	 */
	
	@Modifying //DML에서 필수 !!!
	@Query("update Emp2 e set e.deptno=:deptno where e.empno=:empno")
	public int updateByEmpnoDeptno(@Param("empno") int empno, @Param("deptno") int deptno);
}

// controller - service - repository - rdbms
