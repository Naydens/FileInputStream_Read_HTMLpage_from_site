package FIS;

import java.io.*;


public class ReadAndWriteIOBuffer {
    public static void main(String[] args) {
        File fileInput = new File("C:\\Users\\1\\Desktop\\fileOutputStream.txt");
        File fileOutput = new File("C:\\Users\\1\\Desktop\\fileOutputStreamN.txt");

        try (FileInputStream inputStream = new FileInputStream(fileInput);
             FileOutputStream outputStream = new FileOutputStream(fileOutput)) {
            byte[] buffer = new byte[1024];
            int neededByte;
            while ((neededByte = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, neededByte);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}



