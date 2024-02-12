import java.util.*;
public class Compare{

	public static void main(String[] args){

		String normalString = "pradhis";
		StringBuffer sb = new StringBuffer("pradhis");
		
		//normalString.charAt(3) = "t"; String is immutable so we cannot modify the string
		sb.replace(3,4,"t");
		System.out.println(sb.toString());// Here it is possible to modify the string


		// The concatenation is slower in the normal string class
		normalString+="w";
		normalString+="a";
		normalString+="r";
		normalString+="a";
		normalString+="n";

		sb.append("w");
		sb.append("a");
		sb.append("r");
		sb.append("a");
		sb.append("n");

		System.out.println(sb.toString());
		
		// Also StringBuffer class uses heap memory so it is faster than normal String class operations.

	}

}
