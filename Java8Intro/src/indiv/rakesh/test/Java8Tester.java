/**
 * 
 */
package indiv.rakesh.test;

import org.junit.Ignore;
import org.junit.Test;

import indiv.rakesh.java8.intro.ComparatorDemo;
import indiv.rakesh.java8.intro.IODemo;
import indiv.rakesh.java8.intro.LambdaDemo;
import indiv.rakesh.java8.intro.MapDemo;
import indiv.rakesh.java8.intro.StringDemo;

/**
 * @author rakesh.malireddy
 *
 */
public class Java8Tester {
	
	@Test
	@Ignore
	public void testSJ(){
		
		StringDemo sd = new StringDemo();
		
		String output = sd.joinStrings();
		
		System.out.println(output);
	}
	
	@Test
	@Ignore
	public void testBufferedReader(){
		IODemo iod = new IODemo();
		String errorLine = iod.findErrorLine();
		System.out.println(errorLine);
	}
	
	
	@Test
	@Ignore
	public void testFilesPath(){
		IODemo iod = new IODemo();
		iod.findErrorLineUsingPath();
	}
	
	
	@Test
	@Ignore
	public void readDirectory(){
		IODemo iod = new IODemo();
		iod.readDirectoryEntries();
	}
	
	@Test
	@Ignore
	public void readDirectoryWalk(){
		IODemo iod = new IODemo();
		iod.readDirectoryEntriesUsingWalk();
	}
	
	
	@Test
	@Ignore
	public void compareonLastName(){
		ComparatorDemo cd = new ComparatorDemo();
		cd.compareOnLast();
	}
	
	@Test
	@Ignore
	public void compareonLastNFirst(){
		ComparatorDemo cd = new ComparatorDemo();
		cd.compareOnLastNFirst();
	}
	
	@Test
	@Ignore
	public void mapForEach(){
		MapDemo md = new MapDemo();
		
		md.forEach();
	}
	
	@Test
	@Ignore
	public void mapReaplaceAll(){
		MapDemo md = new MapDemo();
		md.replaceAll();
	}
	
	@Test
	@Ignore
	public void computeIfAbsent(){
		MapDemo md = new MapDemo();
		md.allcomputeOnMap();
	}
	
	@Test
	@Ignore
	public void enhanceMap(){
		MapDemo md = new MapDemo();
		md.enchanceMultiMap();
	}
	

	
	

}
