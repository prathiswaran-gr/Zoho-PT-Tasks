class Father {
	int age = 40;
	void displayAge(){
		System.out.println("Inside father class");
		System.out.println(age);
	}

}


class Child extends Father{
	int age = 20;
	void displayAge(){
		System.out.println("Inside child class");
		System.out.println(age);
	}

}
public class Main{
	public static void main(String[] args){
		Child child = new Child();
		child.displayAge(); // child class overridden the displayAge method
	
	
	}

}
