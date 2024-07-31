/*
 * 학습내용
 * 1. lombok 설치
 * 	- 다운로드 -> maven 설정 파일에 설정 후 저장 -> library가 maven Dependencies 폴더에 자동 다운로드
 * 		-> 자바코드에 애노테이션 설정으로 코드 자동 생성
 * 
 * 2. 애노테이션
 * 	- 1. 표현: @
 * 	- 2. 기능: 고유한 이름 별 고유한 기능
 * 			jdk1.5버전부터 활성화 & framework들 주도적인 설정
 * 	- 3. lombok
 * 		1. setXxx 메소드 자동 생성
 * 		2. getXxx 메소드 자동 생성
 * 		3. 생성자들도 생성
 * 		4. builder pattern 지원
 */

package model.domain;

import org.junit.Test;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import lombok.Builder;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter //각 변수별 데이터 수정 메서드 자동 생성
//@Getter

//step02- builder 코드
@Builder
public class Customer {
	public String pw;
	public int age;
	public String grade;
	
	@Test
	public void test() {
		//pw값만 명시적인 초기화해서 Customer 객체 생성 요청
		Customer c = Customer.builder().pw("비번").build();
		Customer c1 = Customer.builder().grade("등급").build();
		
		//pw, age값만 초기화해 객체 생성 요청
		Customer c2 = Customer.builder().pw("비번").age(11).build();
		
		//...
	}
}

/*
 * 선언: public static void a(){}
 * 호출: class명.a();
 * 		a();
 */