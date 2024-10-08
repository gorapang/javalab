package step01.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionTest1 {

	//파일 존재 및 활용 test
	@Test
	public void fileTest() {
		
		try {
			//key로 value 뽑는 기능의 객체
			Properties p = new Properties();
			
			//new fileinputstream: db.properties 파일로부터 1바이트씩 읽는 객체
			p.load(new FileInputStream("./db.properties"));
			
			System.out.println(p.getProperty("jdbc.driver"));
			
			System.out.println("파일 read 가능");
		} catch (FileNotFoundException e) {
			System.out.println("파일 없음");
			e.printStackTrace(); // 발생된 히스토리 확인
		} catch (IOException e) {
			System.out.println("load 문제 발생");
			e.printStackTrace();
		}
		
		
		
	}
	
	//@Test
    public void oracleConnect() {
        // MySQL 연결 정보 설정
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "scott"; 
        String password = "tiger"; 

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Oracle 데이터베이스에 성공적으로 연결되었습니다.");

            // 연결 해제
            conn.close();
            System.out.println("연결이 성공적으로 해제되었습니다.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("MySQL 데이터베이스 연결 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        
        System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
        
    }
	
	
	//@Test
    public void mysqlConnect() {
        // MySQL 연결 정보 설정
        String url = "jdbc:mysql://localhost:3306/fisa"; // MySQL 서버 URL (본인의 호스트 및 포트에 맞게 수정)
        String user = "root2"; // MySQL 사용자 이름
        String password = "root2"; // MySQL 비밀번호

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("MySQL 데이터베이스에 성공적으로 연결되었습니다.");

            // 연결 해제
            conn.close();
            System.out.println("연결이 성공적으로 해제되었습니다.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("MySQL 데이터베이스 연결 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        
        System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");   
    }
	
}