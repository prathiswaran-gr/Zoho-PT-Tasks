import java.util.Properties;
import java.util.Enumeration;

public class RemovePropertiesWhileEnumerating {
  public static void main(String[] a) {

    Properties props = new Properties();
    props.setProperty("name","prathis");
    props.setProperty("age","20");
    
    Enumeration e = props.propertyNames();

    while (e.hasMoreElements()) {
      String key = (String) e.nextElement();
      if(key.equals("age")){
      	props.remove(key);
      }
      System.out.println(key + " = " + props.getProperty(key));
    }
    
  }
}
