/* 학습 내용
 * - 상속과 다형성 리뷰
 */


package step01_basic;

import model.domain.PeopleDTO;

public class OOP2 {
	//Object o = new Parent(); //자동 형변환 (promotion)
	static Object m1() { 
		return new Parent(); // Parent -> Object 자동 형변환
	}
	
	static Object[] m2() {
		Object[] o = new Object[3]; //모든 클래스의 최상위 root
		o[0] = "str";
		o[1] = 3;
		o[2] = new PeopleDTO("id", 12);
		
		return o;
	}
	
	public static void main(String[] args) {
		
		//m2 호출
		Object[] o = m2();
		
		//index 0의 문자열 길이 출력
		System.out.println(((String)o[0]).length());
		
		//index 2의 id값만 출력
		PeopleDTO peopleDTO = (PeopleDTO)o[2];
		System.out.println(peopleDTO.getName());
		
		//index 2의 id값을 다른 값으로 수정
		peopleDTO.setName("hi");
		
		//index 2의 id값만 출력
		System.out.println(peopleDTO.getName());
		
		
		//Parent p = m1(); //error
		// Object -> Parent는 자동 형변환되지 않음. 자식 타입의 변수에는 명시적인 형변환(typecasting) 필요
		Parent p = (Parent)m1(); 
		p.id = "fisaman";
		//p.printAll();
	}

}
