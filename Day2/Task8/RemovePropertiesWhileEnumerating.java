import java.util.Properties;
import java.util.Enumeration;

public class RemovePropertiesWhileEnumerating {

  public static void displayProperties(Properties props){
  	for(String key : props.stringPropertyNames()){
      		System.out.println(key + " = " + props.getProperty(key));
    	}
  }
  public static void main(String[] a) {

    Properties props = new Properties();
    props.setProperty("name","prathis");
    props.setProperty("age","20");
    
   // Enumeration e = props.propertyNames();
    for(String key : props.stringPropertyNames()){
    	if(key.equals("age")){
      		props.remove(key);
      	}
    }
    displayProperties(props); // prints the properties available in the object.
    
  }
}
