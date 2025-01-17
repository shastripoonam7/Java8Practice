import java.util.concurrent.ConcurrentHashMap;

class ConcurrentDemo {
	static ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap();
	static int count =0;
	public void put() {
		map.put(++count, Thread.currentThread().getName());
	}
	
	
}

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Demostration of  ConcurrentHashMap demo not throwing ConcurrentModification Exception - fail safe iterator*/
		ConcurrentDemo demo = new ConcurrentDemo();
		/* Testing ConcurrentHashMap using Thread */
		Runnable r1 = ()-> {
			for(int i =0;i<10;i++) {
				demo.put();
			}
		};
		
		Thread t1 = new Thread(r1,"A");
		Thread t2 = new Thread(r1,"B");
		Thread t3 = new Thread(r1,"C");
		
		try {
			t1.join(); t2.join(); t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 t1.start(); t2.start(); t3.start();
		
		System.out.println(demo.map);
		

	}

}
