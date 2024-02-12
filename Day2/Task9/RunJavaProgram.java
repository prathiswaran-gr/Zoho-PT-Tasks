import java.io.*;

public class RunJavaProgram {

    public static void main(String[] args) {
        try {
            String command = "java HelloWorld";

            Process process = Runtime.getRuntime().exec(command);


            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            FileWriter fileWriter = new FileWriter("output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String line = "";
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            
            reader.close();
            writer.close();
            process.waitFor();

            System.out.println("Output is written in output.txt file");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

