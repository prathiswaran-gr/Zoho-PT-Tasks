package com.prathis.Synchronization;
class PrintThreadWithSyncronizationMethod{
   synchronized void printThread(String thread){
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

class SyncronizedThread1 extends Thread{
    PrintThreadWithSyncronizationMethod printThreadObject;
    SyncronizedThread1(PrintThreadWithSyncronizationMethod pt){
        this.printThreadObject = pt;
    }
    public void run(){
        printThreadObject.printThread("Thread 1 class thread");
    }
}

class SyncronizedThread2 extends Thread{
    PrintThreadWithSyncronizationMethod printThreadObject;
    SyncronizedThread2(PrintThreadWithSyncronizationMethod pt){
        this.printThreadObject = pt;
    }
    public void run(){
        printThreadObject.printThread("Thread 2 class thread");
    }
}
public class SynchronizationMethod {
    public static void main(String[] args) {
        PrintThreadWithSyncronizationMethod printThreadWithSyncronizationMethod = new PrintThreadWithSyncronizationMethod();
        SyncronizedThread1 t1 = new SyncronizedThread1(printThreadWithSyncronizationMethod);
        SyncronizedThread2 t2 = new SyncronizedThread2(printThreadWithSyncronizationMethod);
        t1.start();
        t2.start();
    }
}
