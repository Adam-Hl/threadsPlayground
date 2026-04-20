package pro1.example0;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // TODO: Odkomentuj řádek a oprav kód

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<100; i++)
        {
            var t = new Thread(()->{
                //System.out.println("Hodnota i je: " + i);
            });
            t.start();
        }
    }
}