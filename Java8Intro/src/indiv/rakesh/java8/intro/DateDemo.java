/**
 * 
 */
package indiv.rakesh.java8.intro;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

/**
 * @author rakesh.malireddy
 *
 */
public class DateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		
		Instant start = Instant.now();
		
		
		for(int i=0; i<1000; i++){
			//do nothing use some time.
			System.out.println("");
		}
		
		Instant end = Instant.now();
		
		Duration delta = Duration.between(start, end);	
		
		long millis = delta.toMillis();
		
		System.out.println("Difference between start and end in milli precission : "+ millis);
		
		
		LocalDate now = LocalDate.now();		
		LocalDate shakesphereDob = LocalDate.of(1584, Month.APRIL, 23);
		
		//Period
		
		Period p = shakesphereDob.until(now);
		long days = shakesphereDob.until(now,ChronoUnit.DAYS);
		
		System.out.println("# years = "+ p.getYears());
		System.out.println("# days = "+ days);
		
		LocalDate nextSunday = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		
		LocalTime nowTime = LocalTime.now();
		LocalTime afternoon = LocalTime.of(13, 15);
		
		LocalTime bedTime = LocalTime.of(23, 0);
		LocalTime wakeUpTime = bedTime.plusHours(8); // 7.00
		
		Set<String> allZones = ZoneId.getAvailableZoneIds();
		
		allZones.stream().forEach(System.out::println);
		
		ZonedDateTime today =
				ZonedDateTime.of(2017, Month.MARCH.getValue(),30, //year, month, day
				10,0,0,0,                                 //hour, min,sec,nano
				ZoneId.of("America/Chicago"));
		
		ZonedDateTime aWeekFromNow = 
				today.plus(Period.ofWeeks(1));
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(aWeekFromNow));
		
		//US/Pacific
		
		ZonedDateTime pacificTime = aWeekFromNow.withZoneSameInstant(ZoneId.of("US/Pacific"));
		
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(pacificTime));
		
		//Instant & Date
		Date date = Date.from(Instant.now());
		Instant instant = date.toInstant();
		
		//Instant & Timestamp
		Timestamp time = Timestamp.from(Instant.now());
		instant = time.toInstant();
		
		//LocalDate & Date
		LocalDate ldate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		date = java.sql.Date.valueOf(ldate);
		
		

	}

}
