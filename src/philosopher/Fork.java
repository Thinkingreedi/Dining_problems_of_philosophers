package philosopher;

/* 餐具类 */
public class Fork {
    private boolean[] status = {false,false,false,false,false};  //将餐具使用状态置为false，表示为未使用状态

    public synchronized void takeFork(){  //同步锁方法，同一时间只能被一个线程访问
        String name = Thread.currentThread().getName();  //获取当前线程id
        int i = Integer.parseInt(name.split("-")[1]);
        while(status[i] || status[(i + 1) % 5]){
            try{
                System.out.println("哲学家" + (i+1) + ": 我正在等待..");
                wait();  //让当前线程进入等待状态，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        status[i] = true;  //将左右餐具状态置为true，表示被占用
        status[(i + 1) % 5] = true;
    }

    public synchronized void putFork(){  //同步锁方法，同一时间只能被一个线程访问
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name.split("-")[1]);
        status[i] = false;  //将餐具状态置为true
        status[(i + 1) % 5] = false;  //将左右餐具状态置为false
        notifyAll();  // 唤醒在该对象上等待的所有线程
    }
}
