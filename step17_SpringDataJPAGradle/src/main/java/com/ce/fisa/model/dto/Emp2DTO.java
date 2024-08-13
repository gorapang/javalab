package com.ce.fisa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
DTO: view에서도 사용 가능
Entity: 절대 view 단에서 사용 금지 - table 구조 자체가 entity

client: 데이터 입력 -> controller : DTO 자동 생성 -> Service -> DAO -> RDBMS
client: 데이터 입력 -> controller : DTO 자동 생성 -> Service -> DAO : entity로 변경해야만 db insert -> RDBMS

 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@ToString
public class Emp2DTO {
	private int empno;
	private String ename;
	private double sal;
	private int deptno;
}
