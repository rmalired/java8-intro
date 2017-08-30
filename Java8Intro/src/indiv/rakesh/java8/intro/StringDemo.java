/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.util.StringJoiner;

/**
 * @author rakesh.malireddy
 *
 */
public class StringDemo {
	
	
	public String joinStrings(){
		
		
		StringJoiner sj = new StringJoiner(",","{","}");
		
		sj.add("tmhp").add("riata trace pkyw").add("austin");
		
		return sj.toString();
	}

}
