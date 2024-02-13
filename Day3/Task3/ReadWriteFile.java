import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile  {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("source.txt");
            FileWriter fileWriter = new FileWriter("destination.txt");
            String content = "";
            int i;
            while((i = fileReader.read()) !=-1 ){
                content+=(char)i; // ASCII value will be converted into character
            }
            fileWriter.write(content);

            fileReader.close();
            fileWriter.close();
            System.out.println("Reading and writing process is done...");

        }
        catch(IOException e){
            System.err.println(e);
        }
    }



}
