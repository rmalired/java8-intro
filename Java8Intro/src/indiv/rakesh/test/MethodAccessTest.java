/**
 * 
 */
package indiv.rakesh.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import org.junit.Ignore;
import org.junit.Test;

import indiv.rakesh.java8.intro.IPerson;
import indiv.rakesh.java8.intro.Person;

/**
 * @author rakesh.malireddy
 *
 */
public class MethodAccessTest {
	

	static  List<Person> personList = new ArrayList<>();
	
	
	static {
		
		 personList.add(new Person("Deborah","Sprightly", "d.sprightly@me.com",LocalDate.of(2017,Month.AUGUST,23)));	   
	     personList.add( new Person("Tom", "Jones","t.jones@me.com",LocalDate.of(2012,Month.AUGUST,15)));
	     personList.add(new Person("Harry","Major","h.major@me.com",LocalDate.of(1990,Month.JULY,9))); 
	     personList.add( new Person("Ethan","Hardy", "e.hardy@you.com",LocalDate.of(2001,Month.JANUARY,15)));
	     personList.add( new Person("Nancy","Smith", "n.smith@you.com",LocalDate.of(1997,Month.SEPTEMBER,18)));
	   
	}
	
	
	@Test
	@Ignore
	public void accessNew(){
		
	    Supplier<Person> f =	Person::new;
	    
	    BiFunction<String, String, Person> f1 = Person::new; //ClassName::new
	    Person rakesh1 = f1.apply("Rakesh", "Malireddy");
	    
	    
	    IPerson<String,String,String,Person> f2 = Person::new;
	    Person rakesh2 = f2.apply("Rakesh", "Malireddy", "rakesh.malireddy@me.com");
	    
	    System.out.println("Lets debug all 3 person objects");
	    
	    Person rakesh =  f.get();
	    System.out.println("printing rakesh");
	    System.out.println(rakesh.getFname() +" "+ rakesh.getLname());
	    System.out.println("Printing rakesh1");
	    System.out.println(rakesh1.getFname()+" "+ rakesh1.getLname());
	    System.out.println("Printing rakesh2");
	    System.out.println(rakesh2.getFname()+" "+ rakesh2.getLname()+" "+ rakesh2.getEmailAddress());
	   
	}
	
	
	
	@Test
	public void accessStaticMethod() {
		
		System.out.println("Collections before sort");
		personList.forEach(System.out::println);
		
		Collections.sort(personList, Person::compareByAge); //ContainingClass::staticMethodName
		
		System.out.println("Collections after sort");
		personList.forEach(System.out::println);
		
	}
	
	
	@Test
	public void accessContainingType() {
		
		
		
	}
	
	@Test
	public void accessInstanceMethod() {
		for(Person p : personList) {
			//String fName = p::getFname;
		}
	}

}
