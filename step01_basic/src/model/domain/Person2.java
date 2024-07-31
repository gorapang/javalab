package model.domain;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Person2 {
	@NonNull //@NotNull : sql값 반드시 적용하라는 설정
	private String id;
	
	private int pw;
	
	@NonNull
	private String address;
	
	//step01 - 컴파일 정상, 실행 불가. 왜? 해결책?
	@Test
	//public void info() {
	//step02 - junit에서는 실행 불가였으나 main 메소드에서는 실행된다
	public static void main(String[] args) {
		
		//Person2 p1 = new Person2();
		Person2 p2 = new Person2("username", 10, "상암");
		System.out.println(p2.id);
	}
}
