package com.prathis.Synchronization;

class WithoutStaticSyncronization{

    synchronized static void printThread(String thread){

            for (int iteration = 0; iteration <5; iteration++){
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

class WithoutStaticSyncronizationThread1 extends Thread{
    WithoutStaticSyncronization synchronizedBlockThread;
    WithoutStaticSyncronizationThread1(WithoutStaticSyncronization pt){
        this.synchronizedBlockThread = pt;
    }
    public void run(){
        synchronizedBlockThread.printThread("Thread 1 class thread");
    }
}

class WithoutStaticSyncronizationThread2 extends Thread{
    WithoutStaticSyncronization synchronizedBlockThread;
    WithoutStaticSyncronizationThread2(WithoutStaticSyncronization pt){
        this.synchronizedBlockThread = pt;
    }
    public void run(){
        synchronizedBlockThread.printThread("Thread 2 class thread");
    }
}
class WithoutStaticSyncronizationThread3 extends Thread{
    WithoutStaticSyncronization synchronizedBlockThread;
    WithoutStaticSyncronizationThread3(WithoutStaticSyncronization pt){
        this.synchronizedBlockThread = pt;
    }
    public void run(){
        synchronizedBlockThread.printThread("Thread 3 class thread");
    }
}
class WithoutStaticSyncronizationThread4 extends Thread{
    WithoutStaticSyncronization synchronizedBlockThread;
    WithoutStaticSyncronizationThread4(WithoutStaticSyncronization pt){
        this.synchronizedBlockThread = pt;
    }
    public void run(){
        synchronizedBlockThread.printThread("Thread 4 class thread");
    }
}
public class StaticSynchronizationProblem {
    public static void main(String[] args) {
        WithoutStaticSyncronization object1 = new WithoutStaticSyncronization();
        WithoutStaticSyncronization object2 = new WithoutStaticSyncronization();

        WithoutStaticSyncronizationThread1 t1 = new WithoutStaticSyncronizationThread1(object1);
        WithoutStaticSyncronizationThread2 t2 = new WithoutStaticSyncronizationThread2(object1);

        WithoutStaticSyncronizationThread3 t3 = new WithoutStaticSyncronizationThread3(object2);
        WithoutStaticSyncronizationThread4 t4 = new WithoutStaticSyncronizationThread4(object2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
