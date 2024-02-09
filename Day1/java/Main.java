package def;
import A.*;
import B.*;
public class Main{

	private void greet(){
		System.out.println("private main");
	}
	public static void main(String[] args){
		//Father a = new Father();
		//a.sayHello();
		Main main = new Main();
		main.greet();
	
	}
}
