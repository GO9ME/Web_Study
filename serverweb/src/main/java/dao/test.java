package dao;

public class test {
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		dao.login("bts", "1234");
	}
}
