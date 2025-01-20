import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ExecutorsnewWorkStealingPoolExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exs = Executors.newWorkStealingPool();
		ThreadPoolExecutor mypool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		System.out.println("size of mypool: " + mypool.getPoolSize());
		exs.submit(new Threadimpl());
		exs.submit(new Threadimpl());
		System.out.println("Total number of thread scheduled:"+mypool.getTaskCount());
		exs.shutdown();

	}
	
	  static class Threadimpl implements Runnable {  
		  
	      public void run() {  
	           
	         try {  
	            Long num = (long) (Math.random() / 30);  
	            System.out.println("Thread Name: " +Thread.currentThread().getName());  
	               TimeUnit.SECONDS.sleep(num);  
	            System.out.println("after sleep Thread Name: " +Thread.currentThread().getName());  
	         } catch (InterruptedException e) {  
	            e.printStackTrace();  
	         }  
	      }  
	   }  

}
