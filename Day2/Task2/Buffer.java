public class Buffer{
	public static void helper(StringBuffer sb){
	
		sb.append(sb.toString()+" world");
	}
	public static void main(String[] args){
	
		StringBuffer sb = new StringBuffer();
		sb.append("Hello");
		helper(sb);
		System.out.println(sb.toString());
	}

}
