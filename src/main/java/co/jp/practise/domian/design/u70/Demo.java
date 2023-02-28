package co.jp.practise.domian.design.u70;

public class Demo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("存档一");
        originator.setState("存档二");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("存档三");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("存档四");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
