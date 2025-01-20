import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SplitIteratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<String> fruits = new ArrayList();
			fruits.add("Apple");
			fruits.add("Mango");
			fruits.add("Orange");
			fruits.add("Pineapple");
			fruits.add("kiwi");
			fruits.add("Papaya");
			fruits.add("Green Apple");
			fruits.add("Chickoo");
			
			Spliterator<String> secondHalf = fruits.spliterator();
			
			// once you use tryAdvance you have to call fruits.spliterator() again to split 
			while((secondHalf.tryAdvance(System.out::println)));
			System.out.println("-----before usage of trysplit-----");
			
			secondHalf = fruits.spliterator();
			Spliterator<String> firstHalf = secondHalf.trySplit();
			while((firstHalf.tryAdvance(System.out::println)));
			System.out.println("--------------");
			while((secondHalf.tryAdvance(System.out::println)));
			
			
	}

}
