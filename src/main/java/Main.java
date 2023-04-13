import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void writeFile() {
        File file = new File("..//java/test.txt");
        //try-with-resources
        try (FileWriter writer = new FileWriter(file))
        {
            String text = "Hello, World!";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void readFileWithInputStream() {
        try(FileInputStream fileInputStream = new FileInputStream("./files/test.txt")) {
            System.out.println("File size is bytes: " + fileInputStream.available());
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                System.out.print((char) buffer[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        //writeFile();
        readFileWithInputStream();
    }

}