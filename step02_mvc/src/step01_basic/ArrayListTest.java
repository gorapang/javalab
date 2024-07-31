/* 학습 내용
 * 1. java.util package 내에 배열과 흡사한 구조로 데이터를 관리하는 타입
 * 		- list
 * 		- Object[]이 아닌 list 사용 이유?
 * 			-> 실시간 동적 메모리 크기 가능
 * 			- 배열은 한 번 생성한 크기는 절대 불변
 * 			- 실행 속도 측면에서는 배열보다는 떨어짐
 * 			- 고정 크기의 데이터 개수를 관리 -> 배열 선언
 * 2. 데이터를 어떤 형식으로 관리할 것인가? 자료구조
 * 		- 데이터 수가 다수, 하나의 변수 - 고유한 index or key 값으로 관리
 * 3. 형식
 * 		- java.util package 클래스로 제공
 * 		- 객체 생성 후 데이터 저장, 삭제, 수정
 * 		- 관리하는 객체 타입에 대한 제약 없음, 객체이기만 하면 참조타입 모두 다 관리 가능
 * 
 * 4. java.util.ArrayList 설계자 관점
 * 	1) 데이터 저장을 위해 메모리 확보 : 객체 생성 
 * 		new ArrayList()
 *  2) 생성된 메모리에 데이터 저장 :
 *  	public boolean add(Object v) { parameter로 유입된 데이터 저장 }
 *  	저장 시 자동 index를 순서에 맞게 부여
 *  3) 저장된 데이터를 활용하기 위해 반환 :
 *  	public Object get(int index) { 특정 위치의 데이터 반환 } 
 *  4) 저장된 데이터 삭제 :
 *  	public boolean remove(int index) { 해당 index 데이터 삭제 } 
 *  5) 저장되어 있는 데이터 개수 : 
 *  	public int size() {}
 */

package step01_basic;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayListTest {


//	@Test
	public void m1() {
		ArrayList al = new ArrayList(); // 10개씩 생성
		al.add("a"); //index 0번째 저장
		al.add("ab"); 
		al.add("abc"); 
		System.out.println(al.size());
		System.out.println(al);
		
		String v = (String)al.get(1); //형번환 생략 시 문법 오류
		System.out.println(v + " " + v.length());
		
		al.remove(1); //1번째 제거, 뒷단 데이터 자동 이동 -> 속도 느림
		System.out.println(al.get(1)); //abc
	}

	@Test
	public void m2() {
		ArrayList<String> al = new ArrayList<String>(); 
		al.add("a"); 
		al.add("ab"); 
		al.add("abc"); 
	
		System.out.println(al.size());
		System.out.println(al);
		
		String v = (String)al.get(1); 
		System.out.println(v + " " + v.length());
		
		al.remove(1); 
		System.out.println(al.get(1));
	}

}
