package zadanie1;

import java.util.Scanner;

public class Zad1b {
    public static void main(String args[]) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Wprowadź liczbę wątków (liczba musi byc większa od 0): ");
        int n = reader.nextInt();
        System.out.println("Ile razy ma się wyświetlić nazwa wątku? ");
        int p = reader.nextInt();
        Thread1b thread1b = new Thread1b(p);
        if(n>0){
            Thread[] ob = new Thread[n];
            for (int i = 0; i < ob.length; i++) {
                int num = i+1;
                ob[i] = new Thread(thread1b, "Thread numer: " + num);
                ob[i].start();
            }
        }else{
            System.out.println("Wprowadz liczbe wieksza od zera!!!");
        }
    }
}

