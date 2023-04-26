package fw;

import java.util.HashMap;

import customer.InsertAction;
import customer.LoginAction;
import prodict.ProductSelect;
import prodict.ShoppingCart;

/*
	FrontServlet이 넘겨준 요청 path를 가지고 실제 실행할 클래스의 객체를 만들어서 리턴하는 작업을 수행
	미리 요청path별 실행할 실제 클래스를 등록한 설정파일을 보고 찾을 수 있도록 하거나 annotation으로 정의하면 분석해서
	실행할 수 있도록 코드가 작성되어 있어야한다
	보통은 설정파일(xml)이나 annotataion으로 하도록 코드가 정의

*/

public class RequestMapping {
	//xml이나 properties설정파일을 파싱해서 요청path와 함께 실행할 객체를 생성해서 맵에 저장하기
	// 요청 path => key, 실행할 객체 => value에서 저장
	private HashMap<String, Action> actionobjMap = new HashMap<String, Action>();
	public RequestMapping() {
		//생성자 내부에서 설정파일을 파싱해서 객체로 만들고 맴버변수인 맵에 저장하는 코드가 정의 코드가 정의되어 있어야함
		
	}
	public Action mapping(String path) {
		// 매개변수로 전달된 path를 분석해서 등록된 Action객체를 먑에서 찾아서 리턴하는 코드가 작성
		// 우리는 if ... else if ... 로 우선처리
		// 현재 코드는 연습용이므로 매핑정보와 실행할 객체가 추가되면 if 문을 수정해야 하지만 실제 설정파일에 등록하는 코드를 작성하면 
		// 자동으로 분석해서 만들어지므로 코드를 변경하지 않아도 된다
		Action action = null;
		if (path.equals("/customer/insert.do")) {
			action = new InsertAction();
		} else if ( path.equals("/login.do")) {
			action = new LoginAction();
		} else if ( path.equals("/product/list.do")) {
			action = new ProductSelect();
		} else if ( path.equals("/product/cart.do")) {
			action = new ShoppingCart();
		}
		
		return action;
	}
}
