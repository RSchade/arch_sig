package com.rayschade;

import com.rayschade.parser.AlgebraLexer;
import com.rayschade.parser.AlgebraParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Scanner;

public class InteractiveMethod extends AlgebraHandleMethod {

    @Override
    protected String collectRawString() {
        System.out.println("Input expression, then press enter");
        var scan = new Scanner(System.in);
        return scan.nextLine();
    }

    @Override
    protected String parse(String raw) {
        var lexer = new AlgebraLexer(CharStreams.fromString(raw));
        var tokens = new CommonTokenStream(lexer);
        var parser = new AlgebraParser(tokens);
        ParseTree tree = parser.s();
        var evalVisitor = new EvalVisitor();
        var prettyPrintVisitor = new PrettyPrintVisitor();
        return tree.accept(prettyPrintVisitor) + "= " + tree.accept(evalVisitor);
    }

    @Override
    protected void handleOutput(String parsed) {
        System.out.println(parsed);
    }
}
