package java8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
	public static void main(String[] args) {
		//Tạo stream từ collection (Stream of Collection)
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		//Đếm số phần tử trong collection
		System.out.println(streamOfCollection.count());
	
		//Stream cũng có thể được tạo từ 1 array hoặc 1 phần của array:
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		//Stream.builder()
		//Stream.builder() được sử dụng khi muốn thêm mới 1 phần vào bên phải stream.
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		
		//Stream.generate()
		//Số phần tử được tạo ra là vô hạn nên cần phải dùng lệnh .limit() để giới hạn số phần tử được tạo ra.
		Stream<String> streamGenerated =
				  Stream.generate(() -> "stackjava").limit(10);
		
		//Stream of String
		Stream<String> streamOfString =
		  Pattern.compile(", ").splitAsStream("a, b, c");
		
		//Chuyển 1 stream sang Collection hoặc array:
		Stream<Integer> intStream = Stream.of(1,2,3,4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println(intList); //prints [1, 2, 3, 4]
		intStream = Stream.of(1,2,3,4); //stream bị đóng nên cần khởi tạo lại (*đọc phần lưu ý cuối bài)
		Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
		System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}
		
		//Stream.filter()
		List<Integer> list = Arrays.asList(3,4,6);
		list.stream().filter(num -> num % 2 == 0).forEach(e -> System.out.print(e+" "));
		
		//Stream.allMatch(), Stream.anyMatch() and Stream.noneMatch()
		List<Integer> listMatch = Arrays.asList(3,5,6);
		System.out.println("allMatch:" + listMatch.stream().allMatch(num -> num % 2 == 0));
		System.out.println("anyMatch:" + listMatch.stream().anyMatch(num -> num % 2 == 0));
		System.out.println("noneMatch:" + listMatch.stream().noneMatch(num -> num % 2 == 0));
		
		//Stream.findAny() and Stream.findFirst()
		List<String> listFind = Arrays.asList("G","B","F","E");
		String any = listFind.stream().findAny().get();
		System.out.println("FindAny: "+ any);
		String first = listFind.stream().findFirst().get();
		System.out.println("FindFirst: "+ first);    
		
		//Stream.distinct()
		//Stream.distinct() trả về 1 stream với các phần tử riêng biệt (không trùng nhau)
		List<Integer> listDistinct = Arrays.asList(3,4,6,6,4);
		System.out.print("Distinct elements: ");
		listDistinct.stream().distinct().forEach(p -> System.out.print(p + ", "));
		
		//Stream map()
		//Sử dụng map() để map (ánh xạ) mỗi phần tử của stream sang 1 giá trị tương ứng. Ví dụ chuyển các string của 1 list sang chữ hoa:
		Stream<String> names = Stream.of("Đặng", "minh", "chiếN");
		System.out.println(names.map(s -> {
		    return s.toUpperCase();
		  }).collect(Collectors.toList()));
		//prints [STACK, JAVA, STACKJAVA.COM]
		
		//Stream.max() and Stream.min()
		List<String> listM = Arrays.asList("G","B","F","E");
		String max = listM.stream().max(Comparator.comparing(String::valueOf)).get();
		System.out.println("Max:"+ max);
		String min = listM.stream().min(Comparator.comparing(String::valueOf)).get();
		System.out.println("Min:"+ min);
		
	}
}
