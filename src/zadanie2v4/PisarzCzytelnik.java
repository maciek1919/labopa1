package zadanie2v4;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PisarzCzytelnik {

    public PisarzCzytelnik(int n, int lp, int lcz){
        int pojemnoscCz = n*lcz;
        BlockingQueue<String> przeczytane = new ArrayBlockingQueue<>(pojemnoscCz);
        AtomicInteger l = new AtomicInteger(0);
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(n);
        Pisarz p = new ProstyPisarz(bq,n, l);
        Czytelnik c = new ProstyCzytelnik(bq,pojemnoscCz, przeczytane);


        for(int b = 0; b < lp; b++) {
            new Thread(p, "Pisarz numer: " + (b+1)).start();
        }
        for(int i = 0; i < lcz; i++) {

            new Thread(c, "Czytelnik numer: " + (i+1)).start();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wprowadz maksymalna ilosc ksiazek: ");
        int n = sc.nextInt();
        System.out.println("Wprowadz liczbe pisarzy: ");
        int lp = sc.nextInt();
        System.out.println("Wprowadz liczbe czytelnikow");
        int lcz = sc.nextInt();
        new PisarzCzytelnik(n, lp, lcz);
    }
}
