package design.patterns.state;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.change();
        trafficLight.change();
        trafficLight.change();
        trafficLight.change();
        trafficLight.change();
    }
}
