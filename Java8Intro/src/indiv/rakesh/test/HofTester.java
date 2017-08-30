package indiv.rakesh.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Ignore;
import org.junit.Test;

import indiv.rakesh.java8.intro.HofDemo;
import indiv.rakesh.java8.intro.Person;

public class HofTester {
	
	

	static  List<Person> personList = new ArrayList<>();
	
	
	public HofTester(){
		// List<Person> personList = new ArrayList<>();
		 personList.add(new Person("Deborah","Sprightly", "d.sprightly@me.com"));	   
	     personList.add( new Person("Tom", "Jones","t.jones@me.com"));
	     personList.add(new Person("Harry","Major","h.major@me.com")); 
	     personList.add( new Person("Ethan","Hardy", "e.hardy@you.com"));
	     personList.add( new Person("Nancy","Smith", "n.smith@you.com"));
	   
	}
	

	@Test
	public void getMe(){
	   HofDemo hd = new HofDemo();
	   Predicate<Person> me = person -> person.getEmailAddress().contains("@me");
	   List<Person> mes= hd.apply(personList, me);
	   mes.forEach(System.out::println);
	}
	
	

	@Test
	public void getYou(){
	   HofDemo hd = new HofDemo();
	   Predicate<Person> you = person -> person.getEmailAddress().contains("@you");
	   List<Person> yous = hd.apply(personList, you);
	   yous.forEach(System.out::println);
	}

}
