package com.prathis.Synchronization;
class PrintThread{
     void printThread(String thread){
        for (int iteration = 0; iteration<5; iteration++){
            System.out.println(thread);
            try{
                Thread.sleep(800);
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}

class Thread1 extends Thread{
    PrintThread printThreadObject;
    Thread1(PrintThread pt){
        this.printThreadObject = pt;
    }
   public void run(){
        printThreadObject.printThread("Thread 1 class thread");
    }
}

class Thread2 extends Thread{
    PrintThread printThreadObject;
    Thread2(PrintThread pt){
        this.printThreadObject = pt;
    }
    public void run(){
        printThreadObject.printThread("Thread 2 class thread");
    }
}
public class WithoutSynchronization {
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        Thread1 t1 = new Thread1(printThread);
        Thread2 t2 = new Thread2(printThread);
        t1.start();
        t2.start();
    }
}
