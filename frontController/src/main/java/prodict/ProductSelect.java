package prodict;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fw.Action;

//---> /product/lis.do 요청시 실행할 클래스 
public class ProductSelect implements Action{
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("상품 목록 조회 기능");
		
	}
}
