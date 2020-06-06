package jndi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ExecTest {
    public ExecTest() throws IOException,InterruptedException{
        String cmd="whoami";
        final Process process = Runtime.getRuntime().exec(cmd);
        printMessage(process.getInputStream());;
        printMessage(process.getErrorStream());
        int value=process.waitFor();
        System.out.println(value);
    }

    private static void printMessage(final InputStream input) {
        new Thread (new Runnable() {
            @Override
            public void run() {

                Reader reader =new InputStreamReader(input);
                BufferedReader bf = new BufferedReader(reader);
                String line = null;
                try {
                    while ((line=bf.readLine())!=null)
                    {
                        System.out.println(line);
                    }
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
