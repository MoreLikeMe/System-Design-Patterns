package design.lld.cabbooking.service;

import design.lld.cabbooking.entity.Rider;

import java.util.ArrayList;
import java.util.List;

public class RiderService {
    private final List<Rider> riders;

    public RiderService(){
        this.riders = new ArrayList<>();
    }

    public Rider createRider(String name, String mobNo){
        Rider rider = new Rider(name, mobNo);
        riders.add(rider);
        return rider;
    }
}
