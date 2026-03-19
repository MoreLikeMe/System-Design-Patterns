package design.proxy;

public class ProxyDAOImpl implements BaseDAO{

    private final BaseDAO dao;

    ProxyDAOImpl(){
        this.dao = new DAOImpl();
    }

    @Override
    public void save() {
        System.out.println("Pre Save Operation");
        dao.save();
        System.out.println("Post Save Operation");
    }

    @Override
    public Object fetch() {
        System.out.println("Pre Fetch Operation");
        dao.fetch();
        System.out.println("Post Fetch Operation");
        return null;
    }
}
