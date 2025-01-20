import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class CustomerNames implements Consumer<String>{

	@Override
	public void accept(String t) {
		// TODO Auto-generated method stub
		System.out.println(t);
		
	}
	
	
	
}

public class ConsumerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList();
		list.add("Poonam");
		list.add("Shastri");
		list.add("Renu");
		list.add("Sharma");
		
		CustomerNames customerNames = new CustomerNames();
		list.forEach(customerNames);
		
		System.out.println("--*--*--Demostrating andThen() usage --*--*--*--");
		
		Consumer<Integer> c1 = i->System.out.println("I am first consumer:"+i);
         
	    Consumer<Integer> c2 = i->System.out.println("I am second consumer:"+2*i);
	    
	    Consumer<Integer> c3 = i->System.out.println("I am third consumer:"+3*i);
	         
	    c1.andThen(c2).andThen(c3).accept(5);
		
	}

}
