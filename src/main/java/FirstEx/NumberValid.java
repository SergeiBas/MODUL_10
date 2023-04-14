package FirstEx;

import java.io.*;
import java.util.ArrayList;

public class NumberValid {
    ArrayList<Character> arrayListNumbers = new ArrayList<>();
    public void readFileWithInputStream() {
        try(FileInputStream fileInputStream = new FileInputStream("./files/numbers.txt")) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                System.out.print((char) buffer[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
    public void printArray(){
        for (char Item: arrayListNumbers) {
            System.out.print(Item);
        }
    }

    public static void main(String[] args) {
        NumberValid numberValid = new NumberValid();
        numberValid.makeArrayWithInputStream();
        numberValid.printArray();
    }
}
