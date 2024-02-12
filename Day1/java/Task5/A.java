package D1;
import D2.*;
public class A{

	public static void main(String[] args){
		String classpath = "/home/prathis-pt7568/Documents/Day1/java/Task5/D2/:/home/prathis-pt7568/Documents/Day1/java/Task5/D1/";
		System.setProperty("java.class.path", classpath);
		B obj = new B();
		System.out.println(obj.add(7,8));
	
	}
}

