package zadanie1;

public class Thread1b implements Runnable{
    private int a;

    public Thread1b(int a) {
        this.a = a;
    }
    @Override
    public void run() {
        for(int i = 0; i <a; i++)
        System.out.println(Thread.currentThread().getName());
    }
}
