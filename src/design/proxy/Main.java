package design.proxy;

public class Main {
    public static void main(String[] args) {
        BaseDAO dbObj = new ProxyDAOImpl();
        dbObj.save();
        dbObj.fetch();
    }
}
