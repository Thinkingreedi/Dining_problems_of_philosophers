package philosopher;

/* 测试类 */
public class Main {
    public static void main(String[] args){
        Fork fork = new Fork();
        for (int i = 0; i < 5; i++) {
            new Philosopher(i,fork).start();
        }
    }
}
