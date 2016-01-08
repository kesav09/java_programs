package threads;

public class Deadlock2 implements Runnable{
	
	A a = new A();// Object a
	B b = new B();// Object b
	
	public Deadlock2(){
		
		Thread t = new Thread(this);
		t.setName("Thread A");
		t.start();// Start Thread A
		
		a.method(b);
	}
	
	public static void main(String[] args){
		new Deadlock2();
	}
	
	public void run(){
		b.method(a);
	}
}

class A{
	
	synchronized void method(B b){// locked on Object A
		System.out.println("inside Class A's method. Thread:" + Thread.currentThread().getName());
		
		b.last();
	}
	
	synchronized void last(){// locked on Object A
		System.out.println("inside Class A's last method.");
	}
	
}

class B {
	
	synchronized void method(A a){// locked on Object B
		System.out.println("inside Class B's method. Thread:" + Thread.currentThread().getName());
		
		a.last();
	}
	
	synchronized void last(){// locked on Object B
		System.out.println("inside Class B's last method.");
	}
}
