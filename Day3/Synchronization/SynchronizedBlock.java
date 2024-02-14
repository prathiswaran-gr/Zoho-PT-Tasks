package com.prathis.Synchronization;
class SynchronizedBlockThread{
     void printThread(String thread){
         synchronized (this){ // synchronized block
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
}

class SyncronizedBlockThread1 extends Thread{
    SynchronizedBlockThread synchronizedBlockThread;
    SyncronizedBlockThread1(SynchronizedBlockThread pt){
        this.synchronizedBlockThread = pt;
    }
    public void run(){
        synchronizedBlockThread.printThread("Thread 1 class thread");
    }
}

class SyncronizedBlockThread2 extends Thread{
    SynchronizedBlockThread synchronizedBlockThread;
    SyncronizedBlockThread2(SynchronizedBlockThread pt){
        this.synchronizedBlockThread = pt;
    }
    public void run(){
        synchronizedBlockThread.printThread("Thread 2 class thread");
    }
}
public class SynchronizedBlock {
    public static void main(String[] args) {
        SynchronizedBlockThread synchronizedBlockThread = new SynchronizedBlockThread();
        SyncronizedBlockThread1 t1 = new SyncronizedBlockThread1(synchronizedBlockThread);
        SyncronizedBlockThread2 t2 = new SyncronizedBlockThread2(synchronizedBlockThread);
        t1.start();
        t2.start();
    }
}
