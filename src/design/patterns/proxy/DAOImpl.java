package design.patterns.proxy;

public class DAOImpl implements BaseDAO{
    @Override
    public void save() {
        System.out.println("DB Save Operation");
    }

    @Override
    public Object fetch() {
        System.out.println("DB Fetch Operation");
        return null;
    }
}
