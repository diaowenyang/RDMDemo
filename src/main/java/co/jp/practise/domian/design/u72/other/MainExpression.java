package co.jp.practise.domian.design.u72.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainExpression implements Expression {
    private Expression expressions;

    public MainExpression(String expression) {
        String[] expre = expression.trim().split("\\s");
        nextExpression(expre);
    }

    public MainExpression(String[] expression) {
        nextExpression(expression);
    }

    /*
        此方法进行解析这个表达式
     */
    public void nextExpression(String[] expression) {
        int bracketNum = 0;
        boolean isAndOr = false;
        boolean isOver = false;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        int i = 0;
        for (; i < expression.length; i++) {
            switch (expression[i]) {
                case ("("):
                    if (bracketNum > 0) {
                        list1.add(expression[i]);
                    }
                    bracketNum += 1;
                    break;
                case (")"):
                    if (bracketNum > 1) {
                        list1.add(expression[i]);
                    }
                    bracketNum -= 1;
                    break;
                case ("&&"):
                    if (bracketNum == 0) {
                        isAndOr = true;
                        isOver = true;
                    } else {
                        list1.add(expression[i]);
                    }
                    break;
                case ("||"):
                    if (bracketNum == 0) {
                        isAndOr = false;
                        isOver = true;
                    } else {
                        list1.add(expression[i]);
                    }
                    break;
                default:
                    list1.add(expression[i]);
            }
            if (isOver) {
                i += 1;
                break;
            }
        }

        for (; i < expression.length; i++) {
            list2.add(expression[i]);
        }

        if (list2.size() <= 0) {
            if (list1.size() == 3) {
                this.expressions = new LessExpression(list1.toArray(new String[list1.size()]));
            } else {
                this.expressions = new MainExpression(list1.toArray(new String[list1.size()]));
            }
        } else {
            if (isAndOr) {
                this.expressions = new AddExpression(list1.toArray(new String[list1.size()]), list2.toArray(new String[list2.size()]));
            } else {
                this.expressions = new OrExpression(list1.toArray(new String[list1.size()]), list2.toArray(new String[list2.size()]));
            }
        }
    }

    @Override
    public boolean expression(Map<String, Long> stats) {
        return expressions.expression(stats);
    }
}
