package java8.optional;

import java.util.Optional;

public class Optionnal {
	 public static void main(String args[]) {
		    Integer value1 = null;
		    Integer value2 = new Integer(10);
		    // Optional.ofNullable - cho phép truyền vào giá trị null.
		    Optional<Integer> a = Optional.ofNullable(value1);
		    // Optional.of - ném ra lỗi NullPointerException nếu giá trị truyền vào bằng null
		    Optional<Integer> b = Optional.of(value2);
		    System.out.println(sum(a, b));
		  }
		  public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		    // Optional.orElse - trả về 1 giá trị khác, nếu giá trị trong optional class bằng null
		    // Ở đây mình sẽ trả về 0 nếu giá trị trong option class a = null
		    Integer value1 = a.orElse(new Integer(0));
		    // Optional.get - trả về giá trị bên trong optional class
		    Integer value2 = b.get();
		    return value1 + value2;
		  }

}
