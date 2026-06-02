package design.lld.splitwise.entity;

public class User {
    private String mobNO;
    private String name;

    public User(String mobNO, String name) {
        this.mobNO = mobNO;
        this.name = name;
    }

    public String getMobNO() {
        return mobNO;
    }

    public String getName() {
        return name;
    }
}
