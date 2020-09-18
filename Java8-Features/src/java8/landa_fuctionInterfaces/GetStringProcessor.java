package java8.landa_fuctionInterfaces;

public class GetStringProcessor {
	
	public static String getStr(String input, StringProcessor processor){
	    return processor.process(input);
	}
	
	public static void main(String[] args) {
	    // In ra chữ hoa
	    System.out.println(getStr("Hello Chiến!", new StringProcessor() {
	        @Override
	        public String process(String input) {
	            return input.toUpperCase();
	        }
	    }));
	    
	    // In ra chữ thường
	    System.out.println(getStr("Hello Chiến!", new StringProcessor() {
	        @Override
	        public String process(String input) {
	            return input.toLowerCase();
	        }
	    }));
	    
	    //Output 
	    // HELLO CHIẾN
	    //hell chiến
	    
	    //Xử dụng Lambda Expression
	    System.out.println(getStr("Hello Loda!", input -> input.toUpperCase()));
	    
	    System.out.println(getStr("Hello Loda!", input -> input.toLowerCase()));
	}
}
