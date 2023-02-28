package co.jp.practise.domian.design.u71;

/**
 * 4.关闭的命令
 */
public class TurnOffCommand implements Command {
    private final Television tv;

    public TurnOffCommand(Television tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
