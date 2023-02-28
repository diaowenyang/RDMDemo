package co.jp.practise.domian.design.u71;

/**
 * 5.遥控器类
 */
public class RemoteControl {
    private Command turnOnCommand;
    private Command turnOffCommand;

    public RemoteControl(Command turnOnCommand, Command turnOffCommand) {
        this.turnOffCommand = turnOffCommand;
        this.turnOnCommand = turnOnCommand;
    }

    public void setTurnOnCommand(Command command) {
        this.turnOnCommand = command;
    }

    public void setTurnOffCommand(Command command) {
        this.turnOffCommand = command;
    }

    public void pressTurnOffButton() {
        turnOffCommand.execute();
    }

    public void pressTurnOnButton() {
        turnOnCommand.execute();
    }
}
