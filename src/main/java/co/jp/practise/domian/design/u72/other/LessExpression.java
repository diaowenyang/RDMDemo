package co.jp.practise.domian.design.u72.other;

import java.util.Map;

public class LessExpression implements Expression {
    //1为> 2为< 3为 ==
    int operation = 0;
    String key;
    Long value;

    public LessExpression(String[] expres) {
        if (expres.length != 3) {
            throw new RuntimeException("格式不对");
        }
        if (">".equals(expres[1])) {
            operation = 1;
        } else if ("<".equals(expres[1])) {
            operation = 2;
        } else if ("==".equals(expres[1])) {
            operation = 3;
        }
        key = expres[0];
        try {
            value = Long.parseLong(expres[2]);
        } catch (ClassCastException e) {
            throw new RuntimeException("格式无法转换");
        }
    }

    @Override
    public boolean expression(Map<String, Long> stats) {
        if (!stats.containsKey(key)) {
            return true;
        }
        Long value = stats.get(key);
        if (operation == 1) {
            return value > this.value;
        } else if (operation == 2) {
            return value < this.value;
        } else if (operation == 3) {
            return value.equals(this.value);
        }
        return false;
    }
}
