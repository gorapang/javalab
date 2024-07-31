/* 배열
 * - 하나의 변수로 다수의 데이터 관리
 * - 데이터 구분은 고유한 index
 * - index의 시작은 0부터
 * - 모든 배열은 객체 (heap 메모리에 저장)
 * - python: list len() 데이터 개수 파악
 * - js: length 변수가 자동 생성
 * - java: length 변수가 자동 생성 (메모리 크기 값)
 * - java의 배열 생성 문법: {값1, 값2, ...}
 */

package step01_basic;

import org.junit.Test;

import model.domain.PeopleDTO;

public class ArraySyntax {
	
	//1차원 배열 정석 문법
	public void m1() {
		int[] i = new int[3]; //메모리 생성
		i[0] = 10;
		int i2 = 0; // 로컬변수 선언 시 자동초기화 불가 -> 사용 전 값 대입 필수
		System.out.println(i[0]);
		System.out.println(i2);
		
		System.out.println("***************");
		
		//String 참조 타입으로 배열 생성, 값 대입, 활용
		//String 객체 생성 방법: " " or new String(" ")
		String[] s = new String[2];
		System.out.println(s[0]); //null
		s[0] = "test";
		System.out.println(s[0]); //test
		
		
		//PeopleDTO 참조 타입으로 배열 생성, 값 대입, 활용
		//new PeopleDTO()
		PeopleDTO[] p = new PeopleDTO[2];
		System.out.println(p[0]); //null
		p[0] = new PeopleDTO("성호", 10);
		System.out.println(p[0]);
		System.out.println(p[0].getName());
		
		/*
		 * p[0].getName()
		 * p: peopleDTO 배열
		 * p[0]: peopleDTO
		 * getName(): String 
		 */
	}
	
	//1차원 배열 함축 문법
	@Test
	public void m2() {
		int[] i = {1, 2, 3};
		String[] s = {"a", null}; //2개의 메모리 + length 변수 생성
		PeopleDTO[] p = {null, new PeopleDTO("재석", 3)};
	}
	
	
	public PeopleDTO getPeople() {
		PeopleDTO[] p = {null, new PeopleDTO("재석", 3)};
		System.out.println("p[1]: " + p[1]);
		return p[1]; //1번째 데이터 값 반환
	}
	
	
	//test method
	@Test
	public void running() {
		//m1();
		PeopleDTO p = new PeopleDTO();		
		System.out.println("1:" + p);
		
		p = getPeople();
		System.out.println("2: " + p);
		
		//System.out.println(p.getName());
		
		//System.out.println(getPeople().getName());
	}
}
