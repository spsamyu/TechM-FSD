package tasks;

public class BasicThread extends Thread {
    public void run() {
        System.out.println("Hello, Java!");
    }
    public static void main(String[] args) {
        new BasicThread().start();
    }
}
