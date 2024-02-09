public class CallBy{
	// There is no call by reference in java by we can pass the object through the arguments

	public static void helper(int temp){
		temp++;
	}
	public static void helper(long temp){
		temp++;
	}
	public static void helper(double temp){
		temp++;
	}
	public static void helper(int[] val){
	
		val[0]++;
	}
	public static void helper(String str){
		str+="waran";
	}
	public static void helper(String[] strArray){
		strArray[0] = strArray[0]+"waran";
	}
	//public static void helper(UserDefinedClass obj){
	
	//	obj.num++;
	//}
	public static void main(String[] args){
	
	int intValue = 100;
	int longValue = 100;
	int doubleValue = 100;
	
	helper(intValue);
	helper(longValue);
	helper(doubleValue);
	
	System.out.println("After fn call (primitive type)"+intValue); // pass by value 
	System.out.println("After fn call (primitive type)"+longValue); // pass by value 
	System.out.println("After fn call (primitive type)"+doubleValue); // pass by value 
	int arr[] = new int[1];
	String name = "Prathis";
	String[] stringArray = new String[1];
	stringArray[0] = "Prathis";
	arr[0] = 100;
	helper(arr);
	System.out.println("After fn call (reference type) "+arr[0]);
	helper(name);
	System.out.println("After fn call (Constant pool) "+name);
	helper(stringArray);
	System.out.println("After fn call (reference type) "+stringArray[0]);
	
	//UserDefinedClass object = new UserDefinedClass();
	//System.out.println("After fn call (primitive type)"+helper(obj.num)); // pass by value 
	
	//System.out.println("After fn call (reference type) "+helper(obj));
	
	}

}

//public class UserDefinedClass{

//	int num = 5;
//	void display(){
	
//		System.out.println(num);
	
//	}

//}
