package zadanie1;

import java.util.Scanner;

public class Zad1a {

    public static void main(String args[]) {

        Thread1a thread1a = new Thread1a();
        Scanner reader = new Scanner(System.in);
        System.out.println("Wprowadź liczbę wątków (liczba musi byc większa od 0): ");
        int n = reader.nextInt();
        if(n>0){
            Thread[] ob = new Thread[n];  // uzyskac przypadkowa kolejnosc nazw, watki odczekuja losowa ilosc czasu, uzycie kolejki lepsze
            for (int i = 0; i < ob.length; i++) {
                int num = i+1;
                ob[i] = new Thread(thread1a, "Thread numer: " + num);
                ob[i].start();
            }
        }else{
            System.out.println("Wprowadz liczbe wieksza od 0!!");
        }
    }

}