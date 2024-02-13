
public class ThreadRunnable implements Runnable{


    @Override
    public void run() {
        System.out.println("The run method invoked...");
    }

    public static void main(String[] args) {
        ThreadRunnable obj = new ThreadRunnable();
        Thread thread = new Thread(obj, "thread 1");
        thread.start();
        thread.setName("prathis"); // it modifies the thread name thread 1 to prathis
        System.out.println(thread.getName());

    }
}

