package design.lld.parkinglot.entity;

import java.util.HashSet;
import java.util.Set;

public class ParkingFloor {
    private final int floorNo;
    private Set<ParkingSpot> spots;

    public ParkingFloor(int floorNo) {
        this.floorNo = floorNo;
        this.spots = new HashSet<>();
    }

    public void addSpot(ParkingSpot spot){
        spots.add(spot);
    }

    public int getFloorNo() {
        return floorNo;
    }

    public Set<ParkingSpot> getParkingSpots() {
        return spots;
    }
}
