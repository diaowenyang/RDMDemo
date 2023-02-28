package co.jp.practise.domian.design.u72;

/**
 * 或运算
 */
public class OrExpression implements Expression {
    private final Expression expression1;
    private final Expression expression2;

    public OrExpression(Expression e1, Expression e2) {
        this.expression1 = e1;
        this.expression2 = e2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context)
                || expression2.interpret(context);
    }
}
