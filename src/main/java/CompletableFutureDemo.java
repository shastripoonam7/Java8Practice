import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
	static int data =5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("CompletableFuture runAssync() demo ---");
		System.out.println("Before completableFuture:"+data);
		CompletableFuture.runAsync(()->{
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				data = 10;
			});
		System.out.println("After completable future:"+data);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After completable future sleepover:"+data);
		System.out.println("----------------------------------");
		System.out.println("CompletableFuture Creation");
		
		CompletableFuture<String> firstName = CompletableFuture.supplyAsync(()->"I am Poonam");
		CompletableFuture<String> lastName = CompletableFuture.supplyAsync(()->" Shastri");
		CompletableFuture<String> fullName = firstName.thenCombine(lastName, (m1,m2)->m1+" "+m2);
		
		try {
			System.out.println(fullName.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------------------------------");
		System.out.println("Handling  Exception ");
		CompletableFuture justChecking = CompletableFuture.supplyAsync(()->10/0).exceptionally(ex->0); 
		try {
			System.out.println(justChecking.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
