package test;

import java.util.ArrayList;
import java.util.Arrays;

public class LevelUp2 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("1");
		al.add("2");
		al.add("3");
		al.forEach(s -> System.out.println(Integer.parseInt(s)));
		//Integer 객체로 변환되어 저장
		Arrays.asList(1,2,3).forEach(System.out::println);
		Arrays.asList("1","2","3").forEach(System.out::println);
		
	}
}
