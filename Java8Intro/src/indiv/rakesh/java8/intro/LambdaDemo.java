/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.util.concurrent.Executors;

/**
 * @author rakesh.malireddy
 *
 */
public class LambdaDemo {
	
	
	
	Runnable r = new Runnable(){
		@Override
		public void run() {
			int i =0;
			
			while(i++ <10){
				System.out.println(Thread.currentThread().getName() +" "+ i);
			}
		}
	};
	
	
	
	public void executeAnonFunctions(){
		
		System.out.println("Execute Function Thread : "+ Thread.currentThread().getName());
		Executors.newSingleThreadExecutor().execute(r);
	}
	
	// lets remove the cermonious code of the anonymous function
	//Name
	//		ParameterList
	//		Body
	//Return type
	
	Runnable r1 =() ->{
		int i =0;
		
		while(i++ <10){
			System.out.println(Thread.currentThread().getName() +" "+ i);
		}
	};
	
	
	
	public void executeLambda(){
		System.out.println("Execute Function Thread : "+ Thread.currentThread().getName());
		Executors.newSingleThreadExecutor().execute(r1);
	}

}
