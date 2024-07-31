package step01;

public class BasicSyntax2 {

	static String name = "상민";
	int age = 21;
	
	BasicSyntax2(){}
	
	void info() {
		String name2 = "동길";
		int age2 = 22;
		System.out.println(name + ' ' + name2);
	}
	
	
	public static void main(String[] args) {

//		BasicSyntax2 c = new BasicSyntax2(); 
//		
//		System.out.println(c);
//		System.out.println(c.name); 
//		c.info();
	
		name = "fisaman";
		System.out.println(name);
		
	}	

}
