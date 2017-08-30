/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author rakesh.malireddy
 *
 */
public class AdvancedStreamDemo {
	
	
	static  List<Person> personList = new ArrayList<>();
	
	
	static{
			 personList.add(new Person("Deborah","Sprightly", "d.sprightly@me.com",LocalDate.of(2017,Month.AUGUST,23)));	   
		     personList.add( new Person("Tom", "Jones","t.jones@me.com",LocalDate.of(2012,Month.AUGUST,15)));
		     personList.add(new Person("Harry","Major","h.major@me.com",LocalDate.of(1990,Month.JULY,9))); 
		     personList.add( new Person("Ethan","Hardy", "e.hardy@you.com",LocalDate.of(2001,Month.JANUARY,15)));
		     personList.add( new Person("Nancy","Smith", "n.smith@you.com",LocalDate.of(1997,Month.SEPTEMBER,18)));
	         personList.add(new Person("Nathan","Winkel","n.winkel@you.com",LocalDate.of(1997,Month.DECEMBER,25)));
	         personList.add(new Person("Robert","Chalce","r.chalce@me.com",LocalDate.of(1990,Month.MARCH,15)));	   
	}
	
	
	
	//basic use case
	
	public void basicUseCase() {
		Set<Person> nPerson = personList.stream()
		                   .filter(p -> p.getFname().startsWith("N"))
		                   .collect(Collectors.toSet()); // Collectors.toList 
		
		System.out.println(nPerson);
	}
	
	
	//lets group by age, stream to Map	
	public void groupBy() {
		Map<Integer,List<Person>> personsByAge = personList.stream()
				                                           .collect(Collectors.groupingBy(p -> p.getAge()));
		
		//Iterate over map and print
		
		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n ", age,p));
	}
	
	//Lets do aggregation
	
	public void averageAge() {
		Double avgAge = personList.stream().collect(Collectors.averagingInt(p -> p.getAge()));
		System.out.println("Average Age : "+ avgAge);
	}
	
	
	//comprehensive statistics
	
	public void summaryOfPeople() {
		IntSummaryStatistics personSummary = personList.stream().collect(Collectors.summarizingInt(p -> p.getAge()));
		System.out.print(personSummary);
	}
	
	//collectors joining
	
	public void identifyMajors() {
		String majors = personList.stream().filter(p -> p.getAge() >=21).map(p -> p.getFname()).collect(Collectors.joining(" and ", "", " are majors"));
		System.out.println(majors);
	}
	
	//Write your own collectors, it should have a supplier, accumulator, combiner, finisher

}
