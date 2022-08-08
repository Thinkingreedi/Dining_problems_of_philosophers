package philosopher;

/* 哲学家类 */
public class Philosopher extends Thread {
    private final int id;
    private final Fork fork;

    public Philosopher(int name, Fork fork) {
        this.id = name;
        this.fork = fork;
    }

    public void thinking() {
        System.out.println("哲学家" + (id+1) + ": 我开始思考~~");
        try {
            sleep(1000);  //模拟思考
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eating() {
        System.out.println("哲学家" + (id+1) + ": 我正在吃饭!!");
        try {
            sleep(1000);  //模拟吃饭
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("InfiniteLoopStatement")  //抑制无限循环警告
    public void run() {
        while (true) {
            thinking();
            fork.takeFork();
            eating();
            fork.putFork();
        }
    }
}
