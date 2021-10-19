package com.rayschade;

import com.rayschade.parser.AlgebraBaseVisitor;
import com.rayschade.parser.AlgebraParser;

import java.util.Objects;
import java.util.stream.Stream;

public class EvalVisitor extends AlgebraBaseVisitor<Double> {
    @Override
    public Double visitS(AlgebraParser.SContext ctx) {
        return visitExpr(ctx.expr());
    }

    @Override
    protected Double defaultResult() {
        return null;
    }

    private Double parseBinary(AlgebraParser.ExprContext ctx) {
        Double val = null;
        var op = Stream.of(ctx.EXP(), ctx.MIN(), ctx.PLUS(), ctx.MIN(), ctx.DIV())
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
        Double l = ctx.expr(0).getCalcVal();
        Double r = ctx.expr(1).getCalcVal();
        //System.out.println("BINARY: " + l + " " + op + " " + r);
        if (op != null) {
            switch (op.toString()) {
                case "+":
                    val = l + r;
                    break;
                case "-":
                    val = l - r;
                    break;
                case "/":
                    val = l / r;
                    break;
                case "*":
                    val = l * r;
                    break;
                case "^":
                    val = Math.pow(l, r);
                    break;
            }
        }
        return val;
    }

    @Override
    public Double visitExpr(AlgebraParser.ExprContext ctx) {
        var out = visitChildren(ctx);
        //System.out.println(ctx.getText());
        if (ctx.expr().size() == 0) { // terminal
            ctx.setCalcVal(Double.parseDouble(ctx.getText()));
            out = ctx.getCalcVal();
        } else if (ctx.expr().size() == 1) { // unary
            ctx.setCalcVal(ctx.expr(0).getCalcVal()); // parentheses
        } if (ctx.expr().size() == 2) { // binary
            out = parseBinary(ctx);
            ctx.setCalcVal(out);
            //System.out.println("OUT: " + out);
        }
        return out;
    }
}
