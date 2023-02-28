package co.jp.practise.domian.design.u71;


public class Demo {
    public static void main(String[] args) {
        // 命令接受者
        Television tv = new Television();
        TurnOnCommand on = new TurnOnCommand(tv);
        TurnOffCommand off = new TurnOffCommand(tv);
        RemoteControl control = new RemoteControl(on, off);

        control.pressTurnOnButton();
        control.pressTurnOffButton();
    }
}
