

@FunctionalInterface
interface FunctionalInterfaceDemo{
	static int a = 0;
	
	public void showAlien();
	
	default void display() {
		System.out.println("Hi I am from FunctionalInterfaceDemo");
	}
	
}

class UsageFunctionalInterfaceDemo implements FunctionalInterfaceDemo{

	@Override
	public void showAlien() {
		// TODO Auto-generated method stub
		
	}
	
	 public void display() {
		System.out.println("Hi I am from UsageFunctionalInterfaceDemo");
	}
	
}

public class FunctionalInterfaceDD {
	
	public static void main(String args[]) {
		
		FunctionalInterfaceDemo fid = new UsageFunctionalInterfaceDemo();
		fid.display();
		
	}

}
