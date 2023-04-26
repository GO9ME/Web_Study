package fw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 실제 실행할 클래스의 상위타입
public interface Action {
	void run(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException; 
}
