package java8.default_static;

public interface DemoDefault {
	void firstMethod(String string);

//Khi class implements sẽ ko cần phải override 
	default void second(String string) {
		System.out.println(string);
	}
//Static không ghi đè được ở class được implements
	static boolean isNull(String string) {
        System.out.println("Interface Null Check");
        return string == null ? true : "".equals(string) ? true : false;
    }
}
