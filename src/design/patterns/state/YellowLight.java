package design.patterns.state;

public class YellowLight implements State{

    @Override
    public void action(TrafficLight trafficLight) {
        //do yellow light action
        System.out.println("Yellow Light");

        //change state
        trafficLight.setState(new RedLight());
    }
}
