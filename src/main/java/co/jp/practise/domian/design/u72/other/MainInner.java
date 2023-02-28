package co.jp.practise.domian.design.u72.other;

import java.util.HashMap;

public class MainInner {
    public static void main(String[] args) {
        String expression = "( count > 1000 && timeout > 100 ) || ( error > 50 && delay > 10 )";
        String expression1 = "( count > 1000 && timeout > 100 )";
        String expression2 = "( count > 1000 && timeout < 100 )";
        MainExpression mainExpression = new MainExpression(expression2);

        HashMap<String, Long> stats = new HashMap<>();
        stats.put("count", 1200L);
        stats.put("timeout", 1200L);
        stats.put("error", 1200L);
        stats.put("delay", 1200L);

        System.out.println(mainExpression.expression(stats));
    }
}
