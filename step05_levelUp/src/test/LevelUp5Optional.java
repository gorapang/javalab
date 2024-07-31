package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.domain.Customer;

public class LevelUp5Optional {

	public static void main(String[] args) {

		// String s = null;
		// System.out.println(s.length()); //실행 예외 발생

		// step01
		List<String> data1 = Arrays.asList("1", "2", "3", "4", "5");
		List<String> data2 = null;

		System.out.println(data1.stream().mapToInt(Integer::parseInt).count());
		System.out.println(data1.stream().mapToInt(v -> {
			System.out.println("-----");
			return Integer.parseInt(v+"10");
		}).count()); //max()는 --- 출력됨
		
		//둘 중 무엇이 효율적일까?
		System.out.println(data1.stream().mapToInt(Integer::parseInt).filter(v -> v==3).count());
		System.out.println(data1.stream().filter(v -> v.equals("3")).mapToInt(Integer::parseInt).count());
		
		//step02
		//3명의 고객 정보 생성
		//나이가 20미만 고객들의 나이값 합산
		ArrayList<Customer> al1 = new ArrayList<>();
		al1.add(new Customer("id1", "pw1", 10, "상암", "vip", "M"));
		al1.add(new Customer("id2", "pw2", 15, "마포", "gold", "F"));
		al1.add(new Customer("id3", "pw3", 25, "상암", "gold", "F"));
		System.out.println(al1.stream()
							.filter(c -> c.getAge() < 20)
							.mapToInt(Customer::getAge) //.mapToInt(c -> c.getAge())
							.sum());
		
	}

}
