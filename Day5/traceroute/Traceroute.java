import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Traceroute {
    public static void traceroute(String host) {
        Runtime runtime = Runtime.getRuntime();
        Process process;
        try {
            String command = "traceroute " + host;
            process = runtime.exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
            process.destroy();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)  {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Enter the domain url : ");
        try {
            var host = bufferedReader.readLine();
            System.out.println("Please wait ...");
            traceroute(host);

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
