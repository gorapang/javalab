package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.domain.Customer;

public class LevelUp4Stream {

	public static void main(String[] args) {
		
		List<String> datas = Arrays.asList("a", "b", "c", "d", "e");
		List<String> datas2 = Arrays.asList("adv", "b", "casc", "dbfrs", "ess");
		
		//step01
		//? 더블 연산자 + forEach 활용해서 출력해보기
		datas.forEach(v -> System.out.println(v));
		System.out.println("-----step01-----");
		datas.forEach(System.out::println);
		
		//step02 - b 문자열 제회하고 출력
		System.out.println("-----step02-----");
		datas.forEach((v) -> {System.out.println(v);});
		
		System.out.println("-----step02-----");
		datas.forEach(v -> {
			if (!v.equals("b")) { //equals: 객체들의 내용 값 비교 메서드
				System.out.println(v);
			}
		});
		
		//step03 - Stream API 활용한 조건 표현
		System.out.println("-----step03-----");
		datas.stream().filter(v -> !v.equals("b")).forEach(System.out::println);
		
		//step04 - String 길이 출력
		System.out.println("-----step04-----");
		datas2.stream().filter(v -> v.length()!=1).forEach(System.out::println);
		System.out.println("-----step04-----");
		datas2.stream().filter(v -> v.length()!=1).forEach(v -> System.out.println(v.length()));
		
		//step05 - 사용자 정의 객체 타입(참조타입, 클래스타입) 활용
		ArrayList<Customer> al1 = new ArrayList<>();
		al1.add(new Customer("id1", "pw1"));
		al1.add(new Customer("id2", "pw2"));
		al1.add(new Customer("id3", "pw3"));
		
		System.out.println("-----step05-----");
		al1.stream().filter(c -> !c.getId().equals("id2")).forEach(v -> System.out.println(v.getId()));
		
		//step06 - 연산식 
		System.out.println("-----step06-----");
		List<String> data3 = Arrays.asList("1","2","3","4","5");
		int result = data3.stream().mapToInt(Integer::parseInt).sum();
		System.out.println(result); //15
		
		double result2 = data3.stream().mapToDouble(Double::parseDouble).sum();
		System.out.println(result2); //15.0
		
		System.out.println(data3.stream().mapToInt(Integer::parseInt).max()); //OptionalInt[5]
		System.out.println(data3.stream().mapToInt(Integer::parseInt).count()); //5
		System.out.println(data3.stream().mapToInt(Integer::parseInt).min().getAsInt()); //1
	}
}
