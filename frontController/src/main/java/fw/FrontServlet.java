package fw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사이트를 운영하는 동안 모든 요청이 Front Servlet을 통해 요청이 들어올수 있도록 설정
// 확장자가 do,jsp,html인 요청이 오면 FrontServlet이 실행되겠다는 으미ㅣ 
@WebServlet(name = "front", urlPatterns = { "*.do", "*.jsp", "*.html","/" })
public class FrontServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("req.getContextPath()=>" + req.getContextPath());
		System.out.println("req.getRequestURIi()=>" + req.getRequestURI());
		
		String contextPath = req.getContextPath();
		String requestUri = req.getRequestURI();
		
		String path = requestUri.substring(contextPath.length());
		System.out.println("path=>" + path);
		
		// 2. 추출한 요청 path로 등록된 클래스를 찾아서 가져오는 작업
		// RequestMapping 객체에 의뢰 => RequestMapping객체에 선언해놓은 메소드를 호출하면 실제 실행할 객체를 찾아서 리턴
		
		RequestMapping mapObj = new RequestMapping();
		Action action = mapObj.mapping(path);
		
		// 3. Action개게의 run메소드 호출
		action.run(req, resp);
		
		// 4. run 메소드 실행결과를 받아서 응답할 view를 찾는다
		// 5. 응답view를 찾아서 forward하고 redirect하도록 정의
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
