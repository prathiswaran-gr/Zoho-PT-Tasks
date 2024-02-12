public class Scope{

	public void helper(int val){
		val++; // it wont affect the original value of val (Pass by value)
	}
	int commonValue = 5; // member scope the common value is accessed by anywhere within the class
	public static void main(String[] args){
	
		//local scope
		Scope obj = new Scope();
		int val = 5;
		System.out.println("Val before fn call : "+val);
		obj.helper(val);
		System.out.println("Val after fn call : "+val);
		
		
		//method scope
		//System.out.println("The value of x is : "+x); // the value x is cannot be accessed
		int x = 10;
		System.out.println("The value of x is : "+x); // the value x is accessible here
		
	}
}
