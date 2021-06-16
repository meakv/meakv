package Multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockingQueueIMp {
	 
	
	
	
	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
		 ExecutorService executor = new ThreadPoolExecutor(15,
	    		15, 0L, TimeUnit.MILLISECONDS, queue);
	    
	    
	   ((ThreadPoolExecutor)executor).setRejectedExecutionHandler(
			   new RejectedExecutionHandler(){
				   @Override
		            public void rejectedExecution(Runnable r,
		                    ThreadPoolExecutor executor){
		                try {
		                    Thread.sleep(500);
		                } catch (InterruptedException e) {
		                	System.out.println("Exception in the execution" );
		                }
		                executor.submit(r);
				   }   
			   }
			   );
		for(int i=1; i<500;i++) {
			
			executor.execute(new Task(i));
		
		}
				
		executor.shutdown();
		
			try {
				executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
}
