/*
DAO 클래스
- dept01 테이블과 매핑되는 db 연동 클래스

*/

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import db.util.DBUtil;
import model.domain.Dept01DTO;

public class Dept01DAO {
	// 모든 부서 정보 검색
	/*
	 * PreparedStatement API 특징
	 * - db에 요청이 되면 동작 방식
	 * 		- 문장 받고 -> 문법 검증 -> 실행
	 * 매 순간 요청시마다 검증 작업 수행: Statement
	 * 최초 받고 매 요청 시 재사용: PreparedStatement(문법 검증 생략, 속도 빠름)
	 * 
	 * - JPA & Mybatis라는 db 연동 프레임워크들의 기본 API로 내부적으로 사용됨
	 */
	
	@Test //테스트하는 메소드는 반환값이 void여야 한다
	public void junitTest() {
		try {
			System.out.println(getDept01All());
			System.out.println(getDept01One(10));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Dept01DTO> getDept01All() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dept01DTO> datas = null;
		
		try {	
			
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from dept01");
			rs = pstmt.executeQuery();
			
			datas = new ArrayList<>();
			
			while (rs.next()) { //반복횟수가 불명확할때 주로 사용되는 반복문
				datas.add(new Dept01DTO(rs.getInt(1), rs.getString(2), rs.getString(3))); 
			};
			
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		
		return datas;
	}
	
	// 하나의 부서 번호로 검색
	// 필요 데이터: deptno, 반환값: DeptDTO 	
	public Dept01DTO getDept01One(int deptno) throws SQLException {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Dept01DTO dept = null;
	    
	    try {
	        con = DBUtil.getConnection();
	        pstmt = con.prepareStatement("SELECT * FROM dept01 WHERE deptno = ?");
	        pstmt.setInt(1, deptno);
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            dept = new Dept01DTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
	        }
	    } finally {
	        DBUtil.close(con, pstmt, rs);
	    }
	    
	    return dept;
	}

	
	
	// 새로운 부서 정보 저장
	public boolean saveDept01(Dept01DTO oneDept) {
		return false;
	}
}
