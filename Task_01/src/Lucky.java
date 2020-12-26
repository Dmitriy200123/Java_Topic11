public class Lucky {
    static int count = 0;
    private static final StateObject stateObject = new StateObject();

    static class LuckyThread extends Thread {
        @Override
        public void run() {
           stateObject.run();
           count = stateObject.getCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count);
    }
}