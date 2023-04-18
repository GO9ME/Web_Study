package basic;

abstract class A {
	abstract void print();
}

class Sub1 extends A {
	@Override
	void print() {
		// TODO Auto-generated method stub
		System.out.println("Sub1의 print");

	}
}
class Sub2 extends A {
	@Override
	void print() {
		// TODO Auto-generated method stub
		System.out.println("Sub2의 print");

	}
}

public class test {
	public static void run(A obj) {
		obj.print();
	}

	public static void main(String[] args) {
		A obj = new Sub1();
		run(obj);
		A obj2 = new Sub2();
		run(obj2);
	}
}
