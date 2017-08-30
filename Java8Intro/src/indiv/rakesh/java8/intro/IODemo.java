/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author rakesh.malireddy
 *
 */
public class IODemo {
	
	//Buffered Reader lines method using stream
	
	
	//read the first error line using stream	
	public String findErrorLine(){		
		String errorLine = "";
		try(BufferedReader br = 
				                new BufferedReader(
				                new FileReader(
				                new File("c:/temp/Process837InboundProcess0_wdMapP0.err")));){
			
			Stream<String> stream = br.lines();
			
			Optional<String> textLine = 
		    stream.filter(line -> line.contains("$Proxy"))
			      .findFirst();			
			errorLine = (textLine.isPresent())?textLine.get():null;
		}catch(IOException ioe){
			ioe.printStackTrace();
		}		
		return errorLine;
	}
	
	//using paths
	
	public void findErrorLineUsingPath(){
		
		Path path = Paths.get("c:","temp","Process837InboundProcess0_wdMapP0.err");
		try(Stream<String> stream = Files.lines(path);){			
			stream.filter(line -> line.contains("$Proxy"))
			      .findFirst()
			      .ifPresent(System.out::println);
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	
	//Reading directory entries	
	public void readDirectoryEntries(){
		
		Path path = Paths.get("c:", "cor");
		try(Stream<Path> stream = Files.list(path)){ //visit first level entries
			stream.filter(cpath -> cpath.toFile().isDirectory())
			      .forEach(System.out::println);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
     public void readDirectoryEntriesUsingWalk(){ 
		Path path = Paths.get("c:", "cor");
		try(Stream<Path> stream = Files.walk(path,3)){ //depth is set to 3
			stream.filter(cpath -> cpath.toFile().isDirectory())
			      .forEach(System.out::println);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	
	
	

}
