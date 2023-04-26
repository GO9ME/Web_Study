package customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fw.Action;

// ---> /customer/insert.do 요청시 실행할 클래스 
public class InsertAction implements Action{
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("insert 처리하기");
	}
}
