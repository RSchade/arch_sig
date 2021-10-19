package com.rayschade;

import com.rayschade.parser.AlgebraLexer;
import com.rayschade.parser.AlgebraParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Scanner;

public class AlgebraApp {
    public static void main(String[] argv) {
        var scan = new Scanner(System.in);
        var lexer = new AlgebraLexer(CharStreams.fromString(scan.nextLine()));
        var tokens = new CommonTokenStream(lexer);
        var parser = new AlgebraParser(tokens);
        ParseTree tree = parser.s();

        var evalVisitor = new EvalVisitor();
        var prettyPrintVisitor = new PrettyPrintVisitor();

        System.out.println(tree.toStringTree(parser));
        System.out.println(tree.accept(prettyPrintVisitor) + "= " + tree.accept(evalVisitor));
    }
}
