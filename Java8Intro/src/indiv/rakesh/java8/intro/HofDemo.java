/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author rakesh.malireddy
 *
 */
public class HofDemo implements BiFunction<List<Person>, Predicate<Person>, List<Person>> {
	
	/*
	 * (non-Javadoc)
	 * @see java.util.function.BiFunction#apply(java.lang.Object, java.lang.Object)
	 * 
	 * the apply method is receiving another function as input parameter, making it as higher order function
	 */

	@Override
	public List<Person> apply(List<Person> t, Predicate<Person> u) {
		return t.stream().filter(u).collect(Collectors.toList());
	}


}
