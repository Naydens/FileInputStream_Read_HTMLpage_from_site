package FIS;

import java.io.*;
import java.util.ArrayList;

public class ReadFromFileToFileDirectly {
    public static void main(String[] args) {
        File fileInput = new File("C:\\Users\\1\\Desktop\\mySQL_practice\\SELECT rufat babayev.txt");
        File fileOutput = new File("C:\\Users\\1\\Desktop\\fileOutputStream.txt");

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(fileInput);
            outputStream = new FileOutputStream(fileOutput);
            writerToFile(inputStream, outputStream);
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    private static byte[] readerBytes(InputStream stream) throws IOException {
        ArrayList<Integer> listB = new ArrayList<>();
        int i;
        while ((i = stream.read()) != -1) {
            listB.add(i);
        }
        byte[] arr = new byte[listB.size()];
        for (int i1 = 0; i1 < listB.size(); i1++) {
            arr[i1] = (byte) listB.get(i1).intValue();
        }
        return arr;
    }

    private static void writerToFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] arrByte = readerBytes(inputStream);
        outputStream.write(arrByte);
    }

}
