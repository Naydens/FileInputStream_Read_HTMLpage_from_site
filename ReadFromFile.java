package FIS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFromFile {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\1\\Desktop\\SQL_for_project.txt");
            System.out.println(reader(fileInputStream));
            fileInputStream.close();


        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } finally {
            if (fileInputStream != null) {

                try {
                    fileInputStream.close();
                } catch (IOException e) {

                }
            }

        }
    }
    public static String reader(InputStream stream) throws IOException {
        int i;
        StringBuilder sb = new StringBuilder();
        while ((i = stream.read()) != -1) {
            sb.append((char) i);
        }

        return sb.toString();
    }
}
