import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, world!");
        System.err.println("This is an error message");
        // Another way to get input from the console instead of using scanner
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        var input = bufferedReader.readLine();
        System.out.println(input);


    }
}
