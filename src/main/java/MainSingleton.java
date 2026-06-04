class Singleton {
    private static Singleton instance;  // приватное статическое поле

    private Singleton() {}             // приватный конструктор

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// Использование:
public class MainSingleton {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a == b);  // true
    }
}