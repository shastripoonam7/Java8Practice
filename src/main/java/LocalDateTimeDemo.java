import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {
	
	public static void main(String args[]) {
		System.out.println("Hello");
		// Features 1 : Local Date-Time API
		LocalDate localDate = LocalDate.now();
		System.out.println("CurrentDate"+localDate);
		
		LocalTime time = LocalTime.now();
		System.out.println("time"+time);
		
		LocalDateTime dateTime = LocalDateTime.parse("16-12-1995 12:15:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		System.out.println("dateTime:"+dateTime);
		
		// Feature 2 : Zoned Date-Time API
		ZonedDateTime zoned = ZonedDateTime.now();
		System.out.println("Current zone:"+zoned.getZone());
		
		ZoneId zoneId= ZoneId.of("Asia/Tokyo");
		
		System.out.println("withZoneSameLocal demo:"+zoned.withZoneSameLocal(zoneId));
		System.out.println("withZoneSameInstant demo:"+zoned.withZoneSameInstant(zoneId));
		// Feature 3 : Duration and Period API
		
		System.out.println("Date Difference using Period:"+Period.between(LocalDate.now(), LocalDate.of(1995, 12, 16)));
		LocalDateTime dateTime1=dateTime.plus(Duration.ofDays(5));
		System.out.println("dateTime after adding 5 days:"+dateTime);
		
		System.out.println("gap between two dates:"+Duration.between(dateTime, dateTime1));
		
		// Feature 4 : ChronoUnits Enum : java.time.temporal.ChronoUnit enum is added in Java 8 to replace integer values used in old API to represent day, month etc.
		LocalDate date = LocalDate.now();
		LocalDate year = date.plus(2, ChronoUnit.YEARS);
		System.out.println("using chronounit years:"+year);
		System.out.println("using chronunit months:"+date.plus(1, ChronoUnit.MONTHS));
		System.out.println("Using chronounit nextweek:"+date.plus(3,ChronoUnit.WEEKS));
		System.out.println("using chronounit decades:"+date.plus(1,ChronoUnit.DECADES));
		
		
		
	}

}
