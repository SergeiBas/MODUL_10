import java.io.*;
import java.util.ArrayList;

public class NumberValid {
    ArrayList<Character> arrayListNumbers = new ArrayList<>();
    public void validNumbers(){
        makeArrayWithInputStream();
        String buf = "";
        for (char item: arrayListNumbers) {
            buf += item;
        }

        String[] arrN = buf.split("\n");
        buf = buf.replaceAll("[0-9]","x");
        String[] copyX = buf.split("\n");

        for (int i = 0; i < copyX.length; i++) {
            if(copyX[i].equals("(xxx) xxx-xxxx") || copyX[i].equals("xxx-xxx-xxxx")){
                System.out.println(arrN[i]);
            }
        }
    }
    public void makeArrayWithInputStream(){
        try(FileInputStream fileInputStream = new FileInputStream("./files/numbers.txt")) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                arrayListNumbers.add((char)buffer[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
