package design.patterns.state;

public class RedLight implements State{

    @Override
    public void action(TrafficLight trafficLight) {
        //do red light action
        System.out.println("Red Light");

        //change state
        trafficLight.setState(new GreenLight());
    }
}
