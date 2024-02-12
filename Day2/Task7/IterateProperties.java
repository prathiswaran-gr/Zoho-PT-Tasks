import java.util.Properties;
import java.util.Enumeration;

public class IterateProperties {
  public static void main(String[] a) {

    Properties props = System.getProperties();
    Enumeration e = props.propertyNames();

    while (e.hasMoreElements()) {
      String key = (String) e.nextElement();
      System.out.println(key + " = " + props.getProperty(key));
    }
  }
}
