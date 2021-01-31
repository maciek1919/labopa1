package zadanie2v4;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PisarzCzytelnik {

    public PisarzCzytelnik(int n, int lp, int lcz){
        CopyOnWriteArrayList<String> przeczytane = new CopyOnWriteArrayList<>();
        AtomicInteger l = new AtomicInteger(0);
        BlockingQueue<String> abq = new ArrayBlockingQueue<>(n);
        for(int i = 0; i < lcz; i++) {
            Czytelnik c = new ProstyCzytelnik(abq, n, przeczytane);

            new Thread(c, "Czytelnik numer: " + (i+1)).start();
        }
        for(int b = 0; b < lp; b++) {
            Pisarz p = new ProstyPisarz(abq, n, l);
            new Thread(p, "Pisarz numer: " + (b + 1)).start();
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