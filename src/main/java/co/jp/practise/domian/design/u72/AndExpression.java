package co.jp.practise.domian.design.u72;

/**
 * 与运算
 */
public class AndExpression implements Expression {
    private final Expression expression1;
    private final Expression expression2;

    public AndExpression(Expression e1, Expression e2) {
        this.expression1 = e1;
        this.expression2 = e2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context)
                && expression2.interpret(context);
    }
}
