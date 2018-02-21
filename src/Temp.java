import java.util.Stack;

/**
 * Created by kusha on 8/3/2017.
 */
class MyThread extends Thread{
    MyThread(){
        System.out.println(" my thread");
    }

    public void run(){
        System.out.println("bar");
    }

    public void run(String s){
        System.out.println("baz");
    }

}

public class Temp{
    public static void main(String[] args) {
        Thread thread=new MyThread(){
            public void run(){
                System.out.println("foo");
            }
        };
        thread.start();
    }
}