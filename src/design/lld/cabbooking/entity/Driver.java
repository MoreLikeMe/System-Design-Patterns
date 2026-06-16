package design.lld.cabbooking.entity;

import design.lld.cabbooking.entity.enums.CarType;
import design.lld.cabbooking.entity.enums.DriverStatus;

public class Driver {
    private String name;
    private String mobNo;
    private String registrationNumber;
    private CarType carType;
    private DriverStatus driverStatus;

    public Driver(String name, String mobNo, String registrationNumber, CarType carType) {
        this.name = name;
        this.mobNo = mobNo;
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.driverStatus = DriverStatus.OFFLINE;
    }

    public String getName() {
        return name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void markAssigned(){
        this.driverStatus = DriverStatus.ASSIGNED;
    }

    public void markBusy(){
        this.driverStatus = DriverStatus.BUSY;
    }

    public void markAvailable(){
        this.driverStatus = DriverStatus.AVAILABLE;
    }

    public void markOffline(){
        this.driverStatus = DriverStatus.OFFLINE;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", carType=" + carType +
                ", driverStatus=" + driverStatus +
                '}';
    }
}
