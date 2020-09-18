package java8.forEach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {
	
	public static void main(String[] args) 
    { 
        List<String> data = new ArrayList<>(); 
        data.add("Chiến"); 
        data.add("Minh Chiến"); 
        data.add("Đặng Minh Chiến");
        // Sử dụng Iterator
        Iterator<String> itr = data.iterator(); 
        while (itr.hasNext()) {
            System.out.println(itr.next()); 
        } 
        
        System.out.println("\n");
        
        // Sử dụng forEach()
        data.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}	
		});
        
        System.out.println("\n");

        // Sử dụng forEach() 
        // Cho lớp Demo implements lớp Demo
        Demo demo = new Demo();
        data.forEach(demo);
    } 
}
