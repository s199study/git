package thread;

/**
 * @author : 石建雷
 * @date :2019/8/13
 */

public class ThreadWait {


    private static Object object = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + "进入启动");
                    try {
                        object.wait();//使当前线程进入等待（进入Object.wait队列）并释放对象锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + "线程执行结束");
                }
            }
        };
        thread.start();
        Thread thread_2 = new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + "进入启动");
                    try {
                        object.notify();//随机在Object.waitd队列中唤醒一个正在等待该对象锁的线程
                        System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + "唤醒一个等待的线程");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread_2.start();
    }
}

