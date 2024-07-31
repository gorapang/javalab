package model.domain;

import org.junit.Test;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Person3 {
	//step01 - final
	//상수
	private String id;	
	private final int pw;
	private final String address;
	
	@Test
	public static void main(String[] args) {
//		Person3 p2 = new Person3("username", 10, "상암");
//		System.out.println(p2.id);
	}
}
