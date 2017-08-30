/**
 * 
 */
package indiv.rakesh.test;

import org.junit.Ignore;
import org.junit.Test;

import indiv.rakesh.java8.intro.StreamDemo;

/**
 * @author rakesh.malireddy
 *
 */
public class StreamTester {
	
	
	@Test
	@Ignore
	public void testBasic() {
		StreamDemo sd =  new StreamDemo();
		sd.basicMFR();
	}
	
	@Test
	@Ignore
	public void testPrimitive() {
		StreamDemo sd =  new StreamDemo();
		sd.primitiveStreams();
	}
	
	
	@Test
	@Ignore
	public void testLazyStreams() {
		StreamDemo sd = new StreamDemo();
		sd.lazyStream();
	}
	
	@Test
	@Ignore
	public void testOrderMatters() {
		StreamDemo sd = new StreamDemo();
		sd.orderMatters();
	}
	
	@Test
	public void testReuseStreams() {
		StreamDemo sd = new StreamDemo();
		sd.reuseStreams();
	}


}
