package kr.multicampus.erp.user;

import java.util.ArrayList;

import dao.CustomerVO;

public interface EmpDAO {
	// 사원등록을 위한 메소드
	public int insert(EmpDTO user);
	// 전체사원을 조회하는 메소드
	public ArrayList<EmpDTO> select();
	public int delete(String id);
	public EmpDTO getEmpInfo(String id);
	
	public EmpDTO login(String id, String pass);
}
