package design.lld.cabbooking.entity;

public class Rider {
    private String name;
    private String mobNo;

    public Rider(String name, String mobNo) {
        this.name = name;
        this.mobNo = mobNo;
    }

    public String getName() {
        return name;
    }

    public String getMobNo() {
        return mobNo;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "name='" + name + '\'' +
                ", mobNo='" + mobNo + '\'' +
                '}';
    }
}
