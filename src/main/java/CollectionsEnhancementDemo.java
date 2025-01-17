import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsEnhancementDemo {
	
	public static void main(String args[]) {
		
		List<String> list = new ArrayList();
		list.add("Poonam");
		list.add("Shastri");
		list.add("Manoj");
		list.add("Ramdulari");
		list.add("Jecily");
		
		/*Using removeIf method java 8 collection feature*/
		list.removeIf(str->str.startsWith("S"));
		System.out.println(list);
		
		/* using spliterator to split*/
		Spliterator<String> strIterator = list.spliterator();
		strIterator.forEachRemaining(System.out::println);
		System.out.println("strIterator:"+ strIterator.hasCharacteristics(Spliterator.SIZED));
		
		 // Attempt to split
		strIterator = list.spliterator();
		Spliterator<String> strIterator1 = strIterator.trySplit();
		
		System.out.println("----------first array----------------");
		if(strIterator1!=null)
		strIterator1.forEachRemaining(System.out::println);
		
		System.out.println("------------second array------------------");
		
		strIterator.forEachRemaining(System.out::println);
		
		/* New added Map functionality*/
		Map<Integer,String> map = list.stream().distinct().collect(Collectors.toMap(list::indexOf,Function.identity()));
		System.out.println("Map from list:"+map);
		
		Map<Integer,String> map2= new HashMap();
		map.put(2, "Apple"); map.put(7, "Nokia"); map.put(0, "Samsung");
		System.out.println("Second map:"+map2);
		map.putAll(map2);
		System.out.println("Concat  two map:"+map);
		
		map.merge(2, "Mobile", String::concat);
		System.out.println("Demostration of merge function of map:"+map);
		
		
		
	}

}
