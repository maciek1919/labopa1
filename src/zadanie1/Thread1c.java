package zadanie1;

public class Thread1c implements Runnable{
    @Override
    public void run() {
        while(true)
            System.out.println(Thread.currentThread().getName());
    }
}