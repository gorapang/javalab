/*
 * 학습내용
 * 1. java.lang package의 주요 클래스
 * 2. 용도
 * 	- 기본 타입 8가지를 support하기 위해 파생된 타입
 * 	- 객체 타입들로만 관리되어야 하는 데이터 군집에 가령 2 형식의 데이터 저장을 해ㅑㅇ 할 경우
 * 		기본 타입이라 저장 불가 현상 발생
 *	해결책: 2값을 보유한 순수 숫자 형식의 객체로 캡슐화
 *3. 참고
 *	빈번히 사용되는 데이터타입과 형식은 java언어 자체의 표현을 쉽게 지원한다.
 *	1) String 타입은 class기반의 객체 타입임에도 불구하고 new 생성자 없이 " " 표현만으로 자동 객체 생성
 *	2) 배열도 객체이지만 new 생성자 없이 {값1, 값2, ...} 표현만으로 자동으로 객체가 됨
 *
 *결론: new 생성자 없이 데이터 표현만으로 객체가 되는 타입은 2가지 : String, 배열
 */
package step02;

public class WrapperAPI {
	
	static String m1() {
		return "fisa";
	}
	
	static Integer m2() { //autoboxing
		return 3;
	}
	
	int m3() { //unboxing
		Integer i = 5;
		return i;
	}
	
	public static void main(String[] args) {
		int v1 = m2();
		System.out.println(v1);
		int v2 = Integer.parseInt("3"); // Integer 클래스에서 제공 메서드
		//int v3 = ("오"); //왜 안될까?
		
		//jdk 1.4에서 허용되는 문법
		Integer i2 = new Integer(3);
	}
}
