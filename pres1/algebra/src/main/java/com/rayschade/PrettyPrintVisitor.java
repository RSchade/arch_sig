package com.rayschade;

import com.rayschade.parser.AlgebraBaseVisitor;
import com.rayschade.parser.AlgebraParser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class PrettyPrintVisitor extends AlgebraBaseVisitor<String> {
    @Override
    public String visitS(AlgebraParser.SContext ctx) {
        return super.visitS(ctx);
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        if (node.getText().equals("<EOF>")) {
            return "";
        }
        return node.getText() + " ";
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        aggregate = aggregate == null ? "" : aggregate;
        nextResult = nextResult == null ? "" : nextResult;
        return aggregate + nextResult;
    }

    @Override
    public String visitExpr(AlgebraParser.ExprContext ctx) {
        return visitChildren(ctx);
    }
}
