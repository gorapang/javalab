package com.ce.fisa.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.dao.Emp2Repository;
import com.ce.fisa.exception.NotExistEmp2Exception;
import com.ce.fisa.model.dto.Emp2DTO;
import com.ce.fisa.model.entity.Emp2;

import jakarta.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private Emp2Repository empDao;
	
	
	//DTO <-> Entity 변환 기능
	private ModelMapper mapper = new ModelMapper();
	
	
	/*
	repository 검색 반환값인 Entity를 DTO로 변환하여 반환
	 */
	@Override
	public Emp2DTO getEmp(String ename) throws NotExistEmp2Exception {
		Emp2 entity = empDao.findByEname(ename);
		System.out.println("*** getEmp() " + entity);
		if (entity == null) {
			throw new NotExistEmp2Exception();
		}
		
		Emp2DTO empDto = mapper.map(entity, Emp2DTO.class);
		System.out.println(empDto);
		
		return empDto;
	}

	@Override
	public List<Object[]> getEmpsbyDeptno(int deptno) {
		return null;
	}

	
	//사번으로 부서번호 수정하는 메소드
	@Override
	@Transactional
	public boolean updateDeptnoByEmpno(int empno, int newDeptno) throws NotExistEmp2Exception {
		System.out.println("*** 사번으로 부서 이동했습니다 ***");
		int result = empDao.updateByEmpnoDeptno(empno, newDeptno);
		if(result != 1) {
			throw new NotExistEmp2Exception("사번에 일치되는 사원이 없습니다");
		}
		return true;
	}
	

}
