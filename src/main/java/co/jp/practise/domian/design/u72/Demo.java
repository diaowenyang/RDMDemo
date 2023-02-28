package co.jp.practise.domian.design.u72;


public class Demo {

    public static void main(String[] args) {
        Expression A = new TerminalExpression(true);
        Expression B = new TerminalExpression(false);
        Expression andExpr = new AndExpression(A, B);
        Expression orExpr = new OrExpression(A, B);
        System.out.println("A && B: " + andExpr.interpret("A && B"));
        System.out.println("A || B: " + orExpr.interpret("A || B"));
    }

}
