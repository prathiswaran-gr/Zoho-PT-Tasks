import java.util.*;
public class SystemProps{

	public static void main(String[] args){
	
		Properties props = System.getProperties();
		props.list(System.out);
		//System.out.println(props);
	
	}
}
