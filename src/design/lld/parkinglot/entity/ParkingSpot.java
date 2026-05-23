package design.lld.parkinglot.entity;

public class ParkingSpot {
    private final int spotNo;
    private final VehicleType vehicleAllowed;
    private ParkingSpotStatus status;

    public ParkingSpot(int spotNo, VehicleType vehicleAllowed) {
        this.spotNo = spotNo;
        this.vehicleAllowed = vehicleAllowed;
        this.status = ParkingSpotStatus.AVAILABLE;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public VehicleType getVehicleAllowed() {
        return vehicleAllowed;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void occupySpot() {
        this.status = ParkingSpotStatus.OCCUPIED;
    }

    public void releaseSpot() {
        this.status = ParkingSpotStatus.AVAILABLE;
    }
}
