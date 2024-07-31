package step01_basic;

class A {
	static {
		System.out.println("A.class가 메모리에 로딩 시 실행");
	}
	
}

public class ExceptionTest {
	
	// 배열의 인덱스에 어긋나는 action
	
	//byte code(자바 실행파일 *.class)를 메모리에 로딩
	
	public static void main(String[] args) {
		/* 
		 * forName() 제공자 관점
		 * - 호출해서 사용하는 유저에게 경우의 수 고려하게 강요 -> try catch 강제
		 */
		
		//byte code 로딩
		try { //로직 구현부. 단, 예외가 발생할 수 있는 코드 영역
			Class.forName("step01.basic.A--");
			System.out.println("난?");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("로딩하려는 클래스가 없을 때 실행되는 영역");
		}
		
		System.out.println(111);
	}
	
	
	/*
	 * 이름이 없다 = 사용자가 직접 호출 불가, 코드로 호출 불가
	 * 실행 시점: byte code가 메모리에 로딩 시 단 한번 실행
	 * 24시간 365일 구동되는 웹 서버의 웹어플리케이션 
	 * 	- 모든 유저가 공유하는 단일 자원 초기화 시에 권장
	 */
//	static {
//		System.out.println("실행시점?");
//	}
//	public static void main(String[] args) {
//		System.out.println(1);
//	}
	
}
