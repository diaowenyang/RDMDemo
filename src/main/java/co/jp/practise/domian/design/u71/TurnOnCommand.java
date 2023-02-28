package co.jp.practise.domian.design.u71;

/**
 * 3.打开的命令
 */
public class TurnOnCommand implements Command {
    private final Television tv;

    public TurnOnCommand(Television tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.trunOn();
    }
}
