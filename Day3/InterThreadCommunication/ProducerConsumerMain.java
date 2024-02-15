
class ProducerConsumer{
    int items = 0;
    boolean isValueSet = false;
    synchronized public void get(){
        while(!isValueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Get = "+items);
        isValueSet = false;
        notify();
    }
    synchronized public void put(){
        while(isValueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.items++;
        System.out.println("Put = "+items);
        isValueSet = true;
        notify();
    }
}


class Producer extends Thread{
    ProducerConsumer pc;
    Producer(ProducerConsumer obj){
        this.pc = obj;
    }
    @Override
    public void run() {

        while (true){
            pc.put();
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
class Consumer extends Thread{
    ProducerConsumer pc;
    Consumer(ProducerConsumer obj){
        this.pc = obj;
    }
    @Override
    public void run() {
        while (true){
            pc.get();
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }

    }
}
public class ProducerConsumerMain {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Producer producerThread = new Producer(producerConsumer);
        Consumer consumerThread = new Consumer(producerConsumer);
        producerThread.start();
        consumerThread.start();
    }
}
