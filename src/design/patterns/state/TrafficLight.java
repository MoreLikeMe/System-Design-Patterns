package design.patterns.state;

public class TrafficLight {
    private State state;

    TrafficLight(){
        this.state = new RedLight();
    }

    void setState(State state){
        this.state = state;
    }

    void change(){
        state.action(this);
    }
}
