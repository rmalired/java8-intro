/**
 * 
 */
package indiv.rakesh.test;

import org.junit.Ignore;
import org.junit.Test;

import indiv.rakesh.java8.intro.LambdaDemo;
import indiv.rakesh.java8.intro.StreamDemo;

/**
 * @author rakesh.malireddy
 *
 */
public class LambdaTester {
	
	@Test
	@Ignore
	public void testRunnable(){
		LambdaDemo ld = new LambdaDemo();
		ld.executeAnonFunctions();
	}

	@Test
	@Ignore
	public void testLambda(){
		LambdaDemo ld = new LambdaDemo();
		ld.executeLambda();
	}
	
	
	@Test
	public void testStreamBasic(){
		StreamDemo sd = new StreamDemo();
		sd.findYouPeople();
	}
}
