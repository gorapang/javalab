/*
 사용자 정의 예외 클래스
 1. 필요성 - 클래스명으로 상황 판단용으로 주로 사용
 2. 구조
  - 상위클래스 / 생성자
  
  
interafce 용도
1. 스펙
2. 반드시 하위 클래스 필수
3. 메소드 재정의 필수
4. 명명 권장 규칙
   - 하위 클래스명: ~인터페이스Impl.java
 */

package com.ce.fisa.exception;

public class NotExistEmp2Exception extends Exception {

	public NotExistEmp2Exception() {};
	public NotExistEmp2Exception(String message) {
		super(); //
	}
	
}
