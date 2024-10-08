package step01.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import db.util.DBUtil;

public class ConnectionProperty2 {
	
	//select
	//@Test
    public void connect() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
        try {
            conn = DBUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from dept");
            
            while(rs.next()) {
            	System.out.println(rs.getInt("deptno") + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
            
        } finally { 
        	DBUtil.close(conn, stmt, rs);
        }
        
        System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
    }

	// insert 
	@Test
	public void connect2() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
	    try {
	    	//연결
	        conn = DBUtil.getConnection();
	        
	        //실행할 sql 문장 구성
	        stmt = conn.prepareStatement("insert into dept values (?, ?, ?)");
	        stmt.setInt(1, 16);
	        stmt.setString(2, "교육부");
	        stmt.setString(3, "상암");
	        
	        //실제 db에 sql을 실행하는 메소드
	        int result = stmt.executeUpdate();
	        System.out.println(result);
	        
	    } catch(SQLException e) {
	    	e.printStackTrace(); //발생된 예외상황 콘솔에 출력
	    } finally { 
	    	DBUtil.close(conn, stmt);
	    }
	    
	    System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
	}
	
}