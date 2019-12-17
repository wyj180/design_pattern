package com.study.interview.base01;

class ThreadImpl implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("begin ThreadImpl");
            Thread.sleep(8000);
            System.out.println("end ThreadImpl");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TestJoin {

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadImpl());
        t.start();

        try {
            t.join(3000); // 主线程等待t结束，只等1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(t.isAlive()){
            System.out.println("t has not finished");
        }else{
            System.out.println("t has finished");
        }

        System.out.println("join finished");
    }

}
