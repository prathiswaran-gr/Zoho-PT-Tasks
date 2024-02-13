public class ThreadExample extends Thread{
    public void run(){
        System.out.println("The run method is invoked");
    }

    public static void main(String[] args) {
        ThreadExample thread = new ThreadExample();
        thread.start(); // invokes the run method internally
        thread.setName("threadName");
        System.out.println(thread.getName());
    }
}

