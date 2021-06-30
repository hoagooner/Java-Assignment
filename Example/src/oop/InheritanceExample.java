package oop;

public class InheritanceExample {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		
		C obj = new C();
		
		obj.show(a);
		obj.show(b);
		obj.show(c);
	}
}

class A {
	void show(A a) {
		System.out.println("A");
	}
}

class B extends A {
	void show(B b) {
		System.out.println("B");
	}
}

class C extends B {
	void show(A c) {
		System.out.println("C");
	}
}
