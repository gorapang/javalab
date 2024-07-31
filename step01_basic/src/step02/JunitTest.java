/*
 * 1. java.lang 제외한 모든 패키지는 필요 시 import해야 한다.
 * 2. import package명.class명; (선호)
 * 	  import package명.*; (비추, 클래스 찾을 때 패키지 내용 전체를 확인)
 * 3. 단위 테스트를 위한 설정
 * 		1) JUnit 다운로드 및 설정
 * 		2) import 문장으로 설정
 * 		3) @Test로 메소드 기능별 실행
 */

package step02;

import org.junit.Test;

public class JunitTest {
	@Test
	public void test1() {
		String s = null; //값이 없음, 데이터와 기능 없음
		int i = s.length();
		System.out.println("한글");
	}
}
