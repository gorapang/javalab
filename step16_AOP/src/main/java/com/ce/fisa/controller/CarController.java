package com.ce.fisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ce.fisa.biz.Car;

@Controller
public class CarController {
	
	/*
	@Component
	public class Car {
	 */
	@Autowired //타입과 일치되는 스프링 빈을 자동 주입
	private Car car;
	
	//rest get
	@GetMapping("aop1")
	@ResponseBody
	public String m1() throws Exception {
		System.out.println("m1()");
		car.buy();
		System.out.println("-------------");
		
		String data = car.buyReturn();
		System.out.println("Controller에서 리턴 받은 데이터 " + data);
		
		return "m1() 응답";
	}

	@ExceptionHandler
	public String exception(Exception e) {
		e.printStackTrace();
		return e.getMessage();
	}
}
