package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.junit.Test;

import model.domain.Customer;

public class LevelUp6Optional {
	
	/*
	 * 프로그램 실행 중지를 방지하기 위한 처리 코드는 어떻게?
	 */
	//@Test
	public void step08() {
		HashMap<String, Customer> map = null;
		
//		HashMap<String, Customer> map = new HashMap<>();
//		map.put("id1", new Customer("id1", "pw1", 10, "상암", "vip", "M"));
//		map.put("id2", new Customer("id2", "pw2", 15, "마포", "gold", "F"));
//		map.put("id3", new Customer("id3", "pw3", 25, "상암", "gold", "F"));

		Optional<HashMap<String,Customer>> opt = Optional.ofNullable(map);
		
		
		//map이 null이 아닐 때만 실행
		opt.ifPresent(map2 -> {
			System.out.println(map2.values().stream()
   							  .filter(c -> (c.getAge() < 20))
							  .mapToInt(Customer::getAge)
							  .sum());
		});

		System.out.println("정상 실행 완료");
	}
	
	//@Test
	public void step07() {
		//String v = null;
		String v = "fisa";
		Optional<String> opt = Optional.ofNullable(v); 
		
		System.out.println(opt.isEmpty()); //null인 경우 true
		System.out.println(opt.isPresent()); //null인 경우 false
		System.out.println(opt.orElse("Null인 경우 출력"));
		opt.ifPresent(v2 -> System.out.println(v2)); 
		
		System.out.println("정상실행유지");
	}
	
	/*
	 * of(): null불허, 실행 시 예외 발생(NullPointerException)
	 * 		ifPresent() 불필요
	 */
	//@Test
	public void step06() {
		//String v = null;
		String v = "fosa";
		Optional<String> opt = Optional.of(v); //null 불허, null인 경우 실행오류
		
		opt.ifPresent(v2 -> System.out.println(v2)); // null이 아니면 출력
		System.out.println(opt.get()); //ifPresent() 불필요 (of인 경우 null이 들어있지 않음을 보장하므로)
		
	}
	
	/*
	 * ofNullable(): null 또는 실제 객체로 생성
	 * 단, null 필터링은 ifPresent() 활용도 가능
	 * ifPresent(): Optional 객체 내부에 null이면 무시(실행 스킵), 아니면 실행
	 */
	//@Test
	public void step05() {
		//String v = null;
		String v = "fosa";
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println("1-----");
		opt.ifPresent(v2 -> System.out.println(v2)); // null이 아니면 출력
		System.out.println("2-----");
	}
	
	/*
	 * ofNullable: null과 객체 모두 수용
	 * get(): Optional 객체에 저장된 데이터값을 반환하는 메소드
	 * 		Optional 객체가 empty인 경우 실행 예외 발생 (NoSuchElement)
	 */
	//@Test
	public void step04() {
		//String v = null; //Optional.empty
		String v = "fisa"; //Optional[fisa]
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt); 
		System.out.println(opt.get()); 
	}
	
	//@Test //step02 실행 문제 해결
	public void step03() {
		String v = null;
		if (v!=null) {
			System.out.println(v.length());
		}
	}
	
	
	//@Test
	public void step02() {
		String v = null;
		System.out.println(v.length()); //실행 시 NullPointerException 발생
		
	}
	
	//@Test
	public void step01() {
		
		//고유한 index로 데이터 관리
		ArrayList<Customer> al1 = new ArrayList<>();
		al1.add(new Customer("id1", "pw1", 10, "상암", "vip", "M"));
		al1.add(new Customer("id2", "pw2", 15, "마포", "gold", "F"));
		al1.add(new Customer("id3", "pw3", 25, "상암", "gold", "F"));
	
		//고유한 구분값(key)으로 데이터를 구분해서 사용 - map
		//String 타입의 키값으로 Customer 객체를 구분 (오른쪽 <>는 비워둬도 된다)
		//key는 중복 불허(id/email/휴대폰번호 등..)
		
		/*
		 * 고려사항
		 * 1. 실 데이터가 없을수도?
		 * 2. 실 데이터 저장공간인 list 또는 map 메모리가 없을수도?
		 * 		- 변수만 선언된 상태
		 */
//		HashMap<String, Customer> map = null;
		
		HashMap<String, Customer> map = new HashMap<>();
		map.put("id1", new Customer("id1", "pw1", 10, "상암", "vip", "M"));
		map.put("id2", new Customer("id2", "pw2", 15, "마포", "gold", "F"));
		map.put("id3", new Customer("id3", "pw3", 25, "상암", "gold", "F"));
	
		map.forEach((k,v) -> System.out.println(k + " " + v));
		
		//?map에 저장된 모든 고객의 나이 합 출력
//		map.forEach((k,v) -> {n+=v.getAge();});
//		System.out.println(n);
		int sum1 = map.values().stream().mapToInt(Customer::getAge).sum();
		System.out.println(sum1);
		
		//?map에 저장된 나이값이 20 미만인 고객의 나이 합 출력
		//답안
		int sum = map.values().stream()
				.filter(c -> (c.getAge() < 20))
				.mapToInt(Customer::getAge)
				.sum();
		System.out.println(sum);
		
	}

}
