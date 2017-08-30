/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author rakesh.malireddy
 *
 */
public class StreamDemo {
	
	static  List<Person> personList = new ArrayList<>();
	
	
	public StreamDemo(){
		// List<Person> personList = new ArrayList<>();
		 personList.add(new Person("Deborah","Sprightly", "d.sprightly@me.com"));	   
	     personList.add( new Person("Tom", "Jones","t.jones@me.com"));
	     personList.add(new Person("Harry","Major","h.major@me.com")); 
	     personList.add( new Person("Ethan","Hardy", "e.hardy@you.com"));
	     personList.add( new Person("Nancy","Smith", "n.smith@you.com"));
	     personList.add(new Person("Nathan","Winkel","n.winkel@you.com"));
	   
	}
	
	public void findYouPeople(){
		List<String> youList = personList.stream().map(a -> a.getEmailAddress())
		                                          .filter(x -> x.contains("@you"))
		                                          .collect(Collectors.toList());
		
		youList.forEach(System.out::println);
	}
	
	public void findMePeople(){
		List<String> meList = personList.stream().map(a -> a.getEmailAddress())
		                                          .filter(x -> x.contains("@me"))
		                                          .collect(Collectors.toList());
		
		meList.forEach(System.out::println);
	}
	
	
	//Map-filter-reduce pattern
	
	public void basicMFR() {
		personList.stream()
		  .map(p -> p.getFname())
		  .filter(fn -> fn.startsWith("N"))
		  .map(String::toUpperCase)
		  .sorted()
		  .forEach(System.out::println);
	}
	
	
	
	//creation of stream	
	public void createStream() {
		Stream.of("a1","a2","b1").findAny().ifPresent(System.out::println);
	}
	
	//create primitive streams
	
	
	public void primitiveStreams() {
		
		IntStream basicOne = IntStream.of(1,3,5,7); // 1,3,5,7
		
		IntStream range = IntStream.range(1, 4); // 1,2,3
		
		IntStream rangeClosed = IntStream.rangeClosed(1, 4); // 1,2,3,4
		
		IntStream iteratorStream = IntStream.iterate(1, i -> i*2).limit(5); // identity is 1 & i*2 operates on previus value of i
		
		//Boxing
		
		Stream<Integer> BoxedStream =  IntStream.range(0, 5).boxed();
		
		// int to Long
		
		LongStream lStream = IntStream.range(1, 5).mapToLong(i -> i);
		
		//max and min
		OptionalInt maxInt = IntStream.range(1, 5).max();
		
		OptionalInt minInt = IntStream.range(1, 5).min();
		
		//factorial of a number 3
		int factValue = IntStream.range(1, 4).reduce(1, (x,y) -> x* y);
		
		//many more methods on primitive streams such as average,sum
		
		// print all stream values
		
		System.out.println("Basic stream");
		basicOne.forEach(System.out::print);
		System.out.println();
		System.out.println("Range");
		range.forEach(System.out::print);
		System.out.println();
		System.out.println("Range Closed");
		rangeClosed.forEach(System.out::print);
		System.out.println();
		System.out.println("Iterator");
		iteratorStream.forEach(System.out::print);
		System.out.println();
		System.out.println("Boxed");
		BoxedStream.forEach(System.out::print); 
		System.out.println();
		System.out.println("Long");
		lStream.forEach(System.out::print); 
		System.out.println();
		System.out.println("max value");
		maxInt.ifPresent(System.out::print);
		System.out.println();
		System.out.println("min value");
		minInt.ifPresent(System.out::print);
		System.out.println();
		System.out.println("factorial value of 3");
		System.out.println(factValue);
		
	}
	
	
	public void lazyStream() {
		
		System.out.println("Lets filter each person");
		
		personList.stream().filter(p ->{
			System.out.println(" printing name :"+ p.toString());
			return true;
		});
		
		//No terminal operation so intermediate operation is not executed.
		
		System.out.println("why the out line of filter didn't work ?");
		System.out.println("Let me apply the reduce operation on the stream");
		
		personList.stream().filter(p ->{
			System.out.println(p.toString());
			return true;
		}).forEach(System.out::println);
		
	}
	
	
	
	public void orderMatters() {
		
		IntStream.range(1, 11).map(i -> {
			System.out.println("map "+ i);
			 return i ;
		}).filter(i ->{
			System.out.println("Filter "+ i);
			return i%5 ==0;
		}).forEach(i -> {
			System.out.println("for Each "+ i);
		});
		
		
		System.out.println("Too many map operations, can we reduce the map operations?");
		System.out.println("Lets re-order the method chain, bring the filter up in the chain");
		

		IntStream.range(1, 11).filter(i ->{
			System.out.println("Filter "+ i);
			return i%5 ==0;
		}).map(i -> {
			System.out.println("map "+ i);
			 return i ;
		}).forEach(i -> {
			System.out.println("for Each "+ i);
		});
		
		
		System.out.println("Lets add sorting to the whole stream in descending order");
		
		Stream.of(1,2,3,4,5,6,7,8,9,10).sorted((i1,i2)->{
			System.out.println("Sorted "+ i1+" , "+ i2);
			return i2>i1?1:0;
			}).filter(i ->{
			System.out.println("Filter "+ i);
			return i%5 ==0;
		}).map(i -> {
			System.out.println("map "+ i);
			 return i ;
		}).forEach(i -> {
			System.out.println("for Each "+ i);
		});
		
		System.out.println("Looks like sorted is horizontal  operation, the filter map and reduce needs to wait until sorting is done");
		System.out.println("How about we re-arrange the sorting after filter");
		

		Stream.of(1,2,3,4,5,6,7,8,9,10).filter(i ->{
			System.out.println("Filter "+ i);
			return i%5 ==0;
		    }).sorted((i1,i2)->{
			System.out.println("Sorted "+ i1+" , "+ i2);
			return i2>i1?1:0;
			}).map(i -> {
			System.out.println("map "+ i);
			 return i ;
		}).forEach(i -> {
			System.out.println("for Each "+ i);
		});
		
	}

	
	
	public void reuseStreams() {
		
		Stream<Person> stream = personList.stream().filter(p -> p.getFname().startsWith("N"));
		
		boolean isNancyFound = stream.anyMatch( p -> p.getFname().equalsIgnoreCase("Nancy"));
		System.out.println("Nancy found : "+ isNancyFound);
		
		//stream cannot be re-used
		try {
			boolean isNathanFound = stream.anyMatch(p -> p.getFname().equalsIgnoreCase("Nathan")); // throws exception
			
			System.out.println("Nathan found : "+ isNathanFound);
		}catch(IllegalStateException ise) {
			System.out.println("Illegal state exception caught , stream is already closed No more operations on the stream");
		}
		
		
		System.out.println("How do we overcome this limitation");
		System.out.println("How about supplier of streams");
		
		Supplier<Stream<Person>> personSupplier = () -> personList.stream().filter(p -> p.getFname().startsWith("N"));
		
		
		boolean isNancyFoundFromStream = personSupplier.get().anyMatch( p -> p.getFname().equalsIgnoreCase("Nancy"));
		System.out.println("Nancy found from stream supplier : "+ isNancyFoundFromStream);
		
		boolean isNathanFoundFromStream = personSupplier.get().anyMatch( p -> p.getFname().equalsIgnoreCase("Nathan"));
		System.out.println("Nancy found from stream supplier : "+ isNathanFoundFromStream);
		
	}
}
