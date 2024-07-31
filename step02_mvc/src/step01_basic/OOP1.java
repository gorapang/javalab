/* 학습내용
 * 1. 상속
 * 2. 용어
 * 		상속 시키는 주체: 부모 클래스 / 상위 클래스
 * 		상속 받는 주체: 자식 클래스 / 하위 클래스
 * 3. 클래스 구성
 * 		1. 변수 / 생성자 / 메소드
 * 		2. 상속 관계에서 자식이 상속 받는 요소 : 변수와 메소드
 * 			- 자식 클래스 관점에서 데이터 수정, 메소드 기능 편집 (재정의, 오버로딩, 오버라이딩) 
 */

package step01_basic;


class Parent extends Object {
	String id;
	int pw;
	
	Parent() {
		super();
	}
	
	void printAll() {
		System.out.println(id);
		System.out.println(pw);
	}
}


class Child extends Parent { //Object - Parent - Child
	String grade;
	
	void printAll() {
		System.out.println(id);
		System.out.println(pw);
		System.out.println(grade);
	}
}


public class OOP1 extends Object {

	public OOP1() {
		super(); //() 즉 argument가 동일한 상위 클래스의 생성자 호출
	}
	
	public static void main(String[] args) {
		Child c = new Child(); // 객체 생성 = 모든 멤버변수를 사용 가능하게 heap 메모리에 실체화
//		System.out.println(c.id); // null
		
		//상속받은 메소드로 id/pw 값만 출력 -> Child에서 재정의 후 다시 재정의된 메소드 출력
		//c.printAll();
		
		//다형성 - 상속 관계가 전제 조건
		Parent p = new Child();
		p.id = "master";
//		p.grade = "vvip"; //error
		Child c2 = (Child)p;
		c2.grade = "vvip";
		
		p.printAll();
		c2.printAll();
		
		p.id = "fisaman";
		c2.id = "클엔맨";
		System.out.println(p.id); //클엔맨
	}

}
