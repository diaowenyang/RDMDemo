package co.jp.practise.domian.design.u72;

/**
 * 终端表达式
 */
public class TerminalExpression implements Expression {
    private final boolean value;

    public TerminalExpression(boolean value) {
        this.value = value;
    }

    @Override
    public boolean interpret(String context) {
        return value;
    }
}
