import java.util.Arrays;
public class Reverse{

	public static void main(String[] args){
	
	
		StringBuffer sb = new StringBuffer(args[0]);
		sb.reverse(); // in-built method is available in StringBuffer class
		System.out.println(sb.toString());
	}

}

