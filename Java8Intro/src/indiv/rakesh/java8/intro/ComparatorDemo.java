/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author rakesh.malireddy
 *
 */
public class ComparatorDemo {
	
	
	static List<Person> persons = new ArrayList<>();

	public ComparatorDemo() {
		
		
		Person jsmith = new Person("John","Smith","John.smith@mycompany.com");
		Person kng = new Person("Karl","Ng","Kar.ng@mycompany.com");
		Person jesmith = new Person("Jeff","Smith","Jeff.smith@mycompany.com");
		Person tRich= new Person("Tom","Rich","Tom.rich@mycompany.com");		
		
		persons.add(jsmith);
		persons.add(kng);
		persons.add(jesmith);
		persons.add(tRich);
	}
	
	
	public void compareOnLast(){
		Comparator<Person> lnameComparator = Comparator.comparing(Person::getLname);
		Collections.sort(persons, lnameComparator);
		persons.forEach(System.out::println);
	}
	
	public void compareOnLastNFirst(){
		
		Comparator<Person> lnameComparator = Comparator.comparing(Person::getLname)
				                                       .thenComparing(Person::getFname);
		Collections.sort(persons, lnameComparator);
		persons.forEach(System.out::println);
	}
	
	

}
