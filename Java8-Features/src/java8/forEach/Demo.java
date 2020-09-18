package java8.forEach;

import java.util.function.Consumer;

public class Demo implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println(t);
	}

}
