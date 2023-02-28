package co.jp.practise.domian.design.u72.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrExpression implements Expression {
    List<Expression> expressionList = new ArrayList<>();

    public OrExpression(String[] list1, String[] list2) {
        if (list1.length == 3) {
            expressionList.add(new LessExpression(list1));
        } else {
            expressionList.add(new MainExpression(list1));
        }
        if (list2.length == 3) {
            expressionList.add(new LessExpression(list2));
        } else {
            expressionList.add(new MainExpression(list2));
        }
    }

    @Override
    public boolean expression(Map<String, Long> stats) {
        for (Expression expression : expressionList) {
            if (expression.expression(stats)) {
                return true;
            }
        }
        return false;
    }
}
