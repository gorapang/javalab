/*
 * 현업 구조 변환
 * 1. db의 접속 설정 정보를 자바 소스에서 분리
 * 2. 형식
 * 		url/id/pw 등을 구분하기 위한 고유한 별징
 * 		key-value 구조
 * 		properties라는 확장자 파일로 주로 관리
 * 		
 * 		spring에서도 설정에 대한 모든 내용이 properties 파일로 분리되는 근원
 * 3. 개발
 * 		1단계: properties 파일로 분리
 * 		2단계: 자바 소스에서 해당 파일을 read하는 코드로 파일 인식
 * 		3단계: properties 파일의 key로 선별해서 매핑된 데이터 read 후 사용
 */

/*
 * 요청사항
 * - 최적화, db.properties 사용 코드로 리팩터링
 */

package step01.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionProperty {

	private static Properties p = new Properties();
	
	//byte code인 실행 파일이 로딩 시 단 한번만 실행
	//db 연동 driver는 24시간 365일 구동되는 서버에 단 한번만 실행 권장
	static {
		try {
			p.load(new FileInputStream("./db.properties"));
			Class.forName(p.getProperty("jdbc.driver"));
			System.out.println("됐당");
		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
	
	@Test
    public void connect() {
		
        // db 연결 정보 설정
        String url = p.getProperty("jdbc.url");
        String user = p.getProperty("jdbc.id");
        String password = p.getProperty("jdbc.pw");

        try {
            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스에 성공적으로 연결되었습니다.");

            // 연결 해제
            conn.close();
            System.out.println("연결이 성공적으로 해제되었습니다.");

        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        
        System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
        
    }
	
}