package FIS;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class readBigTXTFileFromInternetToFile {
    public static void main(String[] args) {

        File fileOutput = new File("C:\\Users\\1\\Desktop\\fileOutputStream.txt");

        InputStreamReader inputStream = null;
        OutputStream outputStream = null;

        try {
            URL url = new URL("https://norvig.com/big.txt");
            inputStream = new InputStreamReader(url.openStream());
            outputStream = new FileOutputStream(fileOutput);
            writerToFile(inputStream, outputStream);
            inputStream.close();
            outputStream.close();

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
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
    private static byte[] readerBytes(InputStreamReader stream) throws IOException {
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
    private static void writerToFile(InputStreamReader inputStream, OutputStream outputStream) throws IOException {
        byte[] arrByte = readerBytes(inputStream);
        outputStream.write(arrByte);
    }
}

