package com.nowcoder.community;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class ThreadTests {


    public static void main(String[] args){
        MyThread1 myThread1 = new MyThread1();
        Thread t1 = new Thread(myThread1);
        t1.start();
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        MyThread3 myThread3 = new MyThread3();
        FutureTask futureTask = new FutureTask(myThread3);
        new Thread(futureTask).start();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newFixedThreadPool(6);
        ThreadPoolExecutor service  = (ThreadPoolExecutor) executorService;
        executorService.submit(myThread3);//callable return obj;
        executorService.execute(myThread1);


    }

}

class MyThread1 implements Runnable{

    private static synchronized void show(){}
    @Override
    public void run(){
        System.out.println("1");
    }
}
class MyThread2 extends Thread{
    @Override
    public void run(){
        System.out.println("1");
    }
}

class MyThread3 implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 1;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

