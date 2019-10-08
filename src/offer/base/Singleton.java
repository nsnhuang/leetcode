package offer.base;

/**
 * 描述:
 *
 * @author huang
 * @create 2019-09-11 8:21 PM
 */
public class Singleton {

    private Singleton() {}

    private static class Inner {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return Inner.instance;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("start");
        Singleton instance = Singleton.getInstance();
    }

}