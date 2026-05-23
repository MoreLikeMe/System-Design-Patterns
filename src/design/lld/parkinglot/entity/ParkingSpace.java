package design.lld.parkinglot.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpace {
    private final int parkingSpaceId;
    private Map<Integer, ParkingFloor> floors;
    private Map<Integer, Gate> gates;

    public ParkingSpace(int parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
        this.floors = new HashMap<>();
        this.gates = new HashMap<>();
    }

    public void addFloor(ParkingFloor floor){
        floors.put(floor.getFloorNo(), floor);
    }

    public void addGate(Gate gate){
        gates.put(gate.getGateNo(), gate);
    }

    public List<ParkingFloor> getFloors() {
        return new ArrayList<>(floors.values());
    }
}
