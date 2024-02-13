import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {

        String filePath = "random.txt";

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");

            randomAccessFile.seek(10); // 0-based indexing, the pointer points at 11th position


            byte[] readBuffer = new byte[10];
            int bytesRead = randomAccessFile.read(readBuffer);

            if (bytesRead != -1) {
                System.out.println("Read data: " + new String(readBuffer, 0, bytesRead));
            }
            randomAccessFile.seek(20);


            String writeData = "NewData";
            randomAccessFile.write(writeData.getBytes());
            System.out.println("Random Random.txt file created successfully");

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

