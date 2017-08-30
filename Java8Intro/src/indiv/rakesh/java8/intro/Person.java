package indiv.rakesh.java8.intro;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
	
	public enum Sex{
		MALE,FEMALE
	}
	
	/**
	 * Three - argument constructor
	 * @param fname
	 * @param lname
	 * @param emailAddress
	 */
	public Person(String fname, String lname, String emailAddress) {
		super();
		this.fname = fname;
		this.lname = lname;		
		this.emailAddress = emailAddress;
	}
	
	

	/**
	 * No - argument constructor
	 */
	public Person() {
		super();
	}

    /**
     * Two - arg constructor
     * @param fname
     * @param lname
     */
	public Person(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}


    
    /**
     * 4 - arg constructor
     * @param fname
     * @param lname
     * @param birthday
     * @param emailAddress
     */
	public Person(String fname, String lname, String emailAddress, LocalDate birthday) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.birthday = birthday;
		this.emailAddress = emailAddress;
	}
	


	public Person(String fname, String lname, LocalDate birthday, Sex gender, String emailAddress) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}
	
	
	private String fname;
	private String lname;
	private LocalDate birthday;
	private Sex gender;
	private String emailAddress;
	private Integer age;
	

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public static int compareByAge(Person a, Person b){
		return a.birthday.compareTo(b.birthday);
	}
	
	
	public String toString(){
		return lname+" "+fname;
	}
	
   public int compareToIgnoreCase(Person a, Person b) {
	   return a.toString().compareToIgnoreCase(b.toString());
   }



public Integer getAge() {
	
	if(birthday != null) {		
		age = (int) birthday.until(LocalDate.now(), ChronoUnit.YEARS);
	}
	
	return age;
}



public void setAge(Integer age) {
	this.age = age;
}
   
   
	
	
}
