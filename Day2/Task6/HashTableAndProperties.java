import java.util.Hashtable;
import java.util.Properties;
public class HashTableAndProperties {


    public static void main(String[] args){

        Hashtable<String, Integer> hashTable = new Hashtable<>();
        hashTable.put("user_id",7568);
        hashTable.put("age",20);

        System.out.println("HashTable in java");
        System.out.println("--------------");
        System.out.println("user_id = "+hashTable.get("user_id"));
        System.out.println("user_age = "+hashTable.get("age"));
        System.out.println("Size of hashtable : "+hashTable.size()+"\n");

        Properties systemConfig = new Properties();
        System.out.println("Properties in java");
        System.out.println("--------------");
        systemConfig.setProperty("username","prathis-pt7568");
        systemConfig.setProperty("password","*****************");
        System.out.println("username = "+systemConfig.getProperty("username"));
        System.out.println("password = "+systemConfig.getProperty("password"));
        System.out.println("Size of the Properties = "+systemConfig.size());



    }




}
