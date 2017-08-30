/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rakesh.malireddy
 *
 */
public class MapDemo {
	
	
	static Map<String,List<Person>> personMap = new HashMap<>();
	
	
	public MapDemo(){
		
/*		    List<Person> list2014 = Arrays.asList(
			        new Person("Deborah","Sprightly", "d.sprightly@me.com"));
		    personMap.put("2014", list2014);
			    List<Person> list2015 = Arrays.asList(
			        new Person("Tom", "Jones","t.jones@me.com"),
			        new Person("Harry","Major","h.major@me.com"));
			    personMap.put("2015", list2015);
			    List<Person> list2016 = Arrays.asList(
			        new Person("Ethan","Hardy", "e.hardy@you.com"),
			        new Person("Nancy","Smith", "n.smith@you.com"));
			    personMap.put("2016", list2016);*/
			    
			    List<Person> list2014 = new ArrayList<>();
			    		list2014.add(new Person("Deborah","Sprightly", "d.sprightly@me.com"));
			    personMap.put("2014", list2014);
			    
				    List<Person> list2015 = new ArrayList<>();
				       list2015.add( new Person("Tom", "Jones","t.jones@me.com"));
				       list2015.add(new Person("Harry","Major","h.major@me.com"));
				personMap.put("2015", list2015);
				    
				    List<Person> list2016 = new ArrayList<>();
				       list2016.add( new Person("Ethan","Hardy", "e.hardy@you.com"));
				       list2016.add( new Person("Nancy","Smith", "n.smith@you.com"));
				    personMap.put("2016", list2016);
			    
			    
		
	}
	
	
	
	
	//for -each
	
	public void forEach(){
		
		personMap.forEach((year,persons) -> System.out.println(year + "  "+ persons));
	}
	
	
	//replace All
	
	public void replaceAll(){		
		personMap.replaceAll((year,persons) -> {
			persons.replaceAll(person -> {
				person.setFname(person.getFname().toUpperCase());
				person.setLname(person.getLname().toUpperCase());
				return person;
			});
			return persons;
		});		
		forEach();		
	}
	
	//compute if-absent, compute, compute if-present
	
	public void allcomputeOnMap(){		
		Person richard = new Person("Richard", "Hanks","r.hanks@you.com");
		Person susan = new Person("Susan", "Lambert","s.lambert@you.com");
		
		System.out.println("Compute If Absent");
		personMap.computeIfAbsent("2017", persons -> new ArrayList<>())
		         .add(richard);
		forEach();
		
		System.out.println("Compute");
		
		personMap.compute("2018", (year,persons) ->{
			persons = (persons == null) ? new ArrayList<>():persons;
			persons.add(susan);
			return persons;
		});
		forEach();
		
		System.out.println("Compute If Present");		
		personMap.computeIfPresent("2014", (year,persons) -> {
			persons.removeIf(person -> person.getFname().equalsIgnoreCase("Deborah"));
			persons =(persons.size()==0)? null: persons;
			return persons;
		});
		forEach();
		
	}
	
	
	public void enchanceMultiMap(){
		
		Person richard = new Person("Richard", "Hanks","r.hanks@you.com");
		Person susan = new Person("Susan", "Lambert","s.lambert@you.com");
		personMap.getOrDefault("2018", new ArrayList<>()).add(richard); //this wont work
		personMap.getOrDefault("2018", new ArrayList<>()).add(susan);
		forEach();
		
	}

}
