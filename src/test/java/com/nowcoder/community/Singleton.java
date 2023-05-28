package com.nowcoder.community;

public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){}
    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args){
        Print printX = new Print();
        Print printY = new Print();
        Print printZ = new Print();
        printX.setName("X");
        printY.setName("Y");
        printZ.setName("Z");
        printX.start();
        printY.start();
        printZ.start();
    }
}

class Print extends Thread{
    static int number = 1;
    public Object obj = new Object();
    @Override
    public void run(){
        synchronized (obj){
            while (true){
                obj.notify();
                if(number < 10){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    number++;}
                else break;

                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

}