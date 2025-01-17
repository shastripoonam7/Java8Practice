
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConcurrencyAPIDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream<Integer> stream = IntStream.rangeClosed(0, 10).boxed(); // boxed converted intstream to stream
		Stream<Integer> stream1 = IntStream.rangeClosed(0, 10).boxed();
		System.out.println("When using stream the data are in order");
		stream.filter(n->n%2==0).forEach(System.out::println);
		System.out.println("when we use parallel stream the data order is not fixed");
		stream1.parallel().filter(n->n%2==0).forEach(System.out::println); // to order it we can use forEachOrdered
	
	}

}
