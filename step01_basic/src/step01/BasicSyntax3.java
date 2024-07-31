package step01;

public class BasicSyntax3 {
	//static 키워드: 메모리에 name 변수값을 실체화하는 객체 생성 작업 없이도, name을 호출 가능하도록 해줌
	/*
	 * static 키워드가 선언된 변수가 실제 생성되는 시점은 언제일까?
	 * 	- 실행 명령어 시작하자마자 class byte code 메모리에 저장(적재, 로딩)
	 * 	- 로딩 시 자동 생성
	 * 	- 객체 생성 시 별도의 name 변수 공간 생성하지 않음
	 * 
	 * non-static 변수들은 객체 생성 시에 메모리에 생성된다.
	 */
	static String name = "상민"; //생성되는 모든 객체가 공유
	int age = 21;
	
	static int no1 = 0;
	int no2 = 0;
	
	BasicSyntax3(){
		no1 = no1 + 1;
		no2 = no2 + 1;
	}
	
	static void info() {
		String name2 = "동길";
		int age2 = 22;
		System.out.println(name + ' ' + name2);
	}
	
	
	public static void main(String[] args) {
		info(); // 현 코드가 구현된 클래스 내에서 static 메소드인 info를 검색해서 호출
		BasicSyntax3.info(); //외부에서 static 메소드 호출하는 문법
		
		//step02 - static / non-static 변수 차이점 보기
		System.out.println(no1); //0
		
		BasicSyntax3 bs1 = new BasicSyntax3();
		BasicSyntax3 bs2 = new BasicSyntax3();
		System.out.println(bs1.no1 + " " + no1); //2 2			
		System.out.println(bs2.no1 + " " + no1); //2 2
		System.out.println(bs1.no2 + " " + bs2.no2); //1 1

//		BasicSyntax2 c = new BasicSyntax2(); 
//		
//		System.out.println(c);
//		System.out.println(c.name); 
//		c.info();
	
//		name = "fisaman";
//		System.out.println(name);
		
		//API 활용
		/*
		 * Math 데이터가 중요한게 아니라 max값 산출하는 메소드 기능
		 * API 설계자 자체도 사용자들이 주는 값 받고 비교하고 반환하고
		 * 즉 Math 객체 생성할 이유와 필요가 없어서 static으로 제공
		 */
		int v1 = Math.max(10, 20);
		System.out.println(v1); // 20
		
	}	

}
