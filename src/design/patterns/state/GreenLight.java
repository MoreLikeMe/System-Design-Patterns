package design.patterns.state;

public class GreenLight implements State{

    @Override
    public void action(TrafficLight trafficLight) {
        //do green light action
        System.out.println("Green Light");

        //change state
        trafficLight.setState(new YellowLight());
    }
}
