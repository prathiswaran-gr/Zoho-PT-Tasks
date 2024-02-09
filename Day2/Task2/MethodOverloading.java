class SampleOverloadingClass{
	int add(int value1, int value2){
		return value1+value2;	
	
	}
	

}
class ChildSampleOverloadingClass extends SampleOverloadingClass{
	int add(int value1, int value2, int value3){
		return value1+value2+value3;	
	
	}

}
public class MethodOverloading{
	public static void main(String[] args){
		ChildSampleOverloadingClass overloadClassObject = new ChildSampleOverloadingClass();
		System.out.println(overloadClassObject.add(5,6));
		System.out.println(overloadClassObject.add(1,2,3));
	
	
	}

}
