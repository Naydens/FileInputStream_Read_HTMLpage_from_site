package IO;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromInternetIO {
    public static void main(String[] args) {
        URL url;
        int i;
        StringBuffer sbf = new StringBuffer("");
        InputStreamReader inputStreamReader;
        FileOutputStream fileOutputStream = null;
        try {
            url = new URL("https://www.youtube.com/watch?v=pvEqbOC1jhI&ab_channel=GolovachCourses");
            inputStreamReader = new InputStreamReader(url.openStream());
            while ((i = inputStreamReader.read()) != -1) {
                sbf.append((char) i);
            }
            inputStreamReader.close();
            System.out.println(sbf);
        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }

        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\1\\Desktop\\rM.txt");
            byte[] mass = sbf.toString().getBytes();
            fileOutputStream.write(mass);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
