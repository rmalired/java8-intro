/**
 * 
 */
package indiv.rakesh.test;

import org.junit.Ignore;
import org.junit.Test;

import indiv.rakesh.java8.intro.AdvancedStreamDemo;

/**
 * @author rakesh.malireddy
 *
 */
public class LambdaAdvancedTest {
	
	
	@Test
	@Ignore
	public void testBasicUseCase() {
		AdvancedStreamDemo asd = new AdvancedStreamDemo();
		
		asd.basicUseCase();
	}
	
	
	@Test
	@Ignore
	public void testGroupBy() {
		AdvancedStreamDemo asd = new AdvancedStreamDemo();
		asd.groupBy();
	}
	
	
	@Test
	@Ignore
	public void testAveraging() {
		AdvancedStreamDemo asd = new AdvancedStreamDemo();
		asd.averageAge();
	}
	
	@Test
	@Ignore
	public void testStatistics() {
		AdvancedStreamDemo asd = new AdvancedStreamDemo();
		asd.summaryOfPeople();
	}
	
	
	@Test
	public void testJoin() {
		AdvancedStreamDemo asd = new AdvancedStreamDemo();
		asd.identifyMajors();
	}
	
	
	
	
	//flat Map

}
