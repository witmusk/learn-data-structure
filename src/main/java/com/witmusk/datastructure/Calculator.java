package com.witmusk.datastructure;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final static Map<String, Integer> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("+", 1);
        OPERATORS.put("-", 1);
        OPERATORS.put("*", 2);
        OPERATORS.put("/", 2);

    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static int compareOperator(String op1, String op2) {
        return OPERATORS.get(op1).compareTo(OPERATORS.get(op2));
    }

    public static int operate(Integer op1, Integer op2, String opt) {
        Integer res = 0;
        if (opt.equals("+")) {
            res = op1 + op2;
        } else if (opt.equals("-")) {
            res = op1 - op2;
        } else if (opt.equals("*")) {
            res = op1 * op2;
        } else if (opt.equals("/")) {
            res = op1 / op2;
        }
        return res;
    }

    public static int calculate(String exp) {
        String tokens[] = exp.split(" ");
        Stack<Integer> ops = new Stack<>();
        Stack<String> opts = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isOperator(token)) {
                if (opts.size() == 0) {
                    opts.push(token);
                } else {
                    String prevOpt = opts.getTop();
                    while (compareOperator(prevOpt, token) >= 0) {
                        Integer op2 = ops.pop();
                        Integer op1 = ops.pop();
                        String opt = opts.pop();

                        Integer res = operate(op1, op2, opt);
                        ops.push(res);

                        if (opts.size() == 0) {
                            break;
                        }
                        prevOpt = opts.getTop();
                    }

                    opts.push(token);
                }
            } else {
                ops.push(new Integer(token));
            }
        }

        Integer op2 = ops.pop();
        Integer op1 = ops.pop();
        String opt = opts.pop();
        return operate(op1, op2, opt);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.calculate("3 + 2 + 3 * 6 / 2 - 1"));
    }
}
