package java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeAPI {
	public static void main(String[] args) {
		// lấy thời gian hiện tại bằng method now
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zoneDateTime = ZonedDateTime.now();
		System.out.println("localDate: "+ localDate);
		System.out.println("localTime: "+ localTime);
		System.out.println("localDateTime: "+ localDateTime);
		System.out.println("zoneDateTime: "+ zoneDateTime);
		// giảm đi 1 ngày trong localDate
		localDate = localDate.minusDays(1);
		System.out.println("localDate after minus: "+ localDate);
		// công thêm 2 ngày vào localDate
		localDate = localDate.plusDays(2);
		System.out.println("localDate after plus: "+ localDate);
		// tạo đối tượng LocalDate từ ngày chỉ rõ
		LocalDate spec = LocalDate.of(2017, 11, 25);
		System.out.println("spec: " + spec);
		long days = ChronoUnit.DAYS.between(localDate, spec);
	}
}
