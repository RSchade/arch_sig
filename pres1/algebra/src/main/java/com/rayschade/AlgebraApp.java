package com.rayschade;

import com.rayschade.parser.AlgebraLexer;
import com.rayschade.parser.AlgebraParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AlgebraApp {
    public static void main(String[] argv) {
        var lexer = new AlgebraLexer(CharStreams.fromString("1 + 2 / 3"));
        var tokens = new CommonTokenStream(lexer);
        var parser = new AlgebraParser(tokens);
        ParseTree tree = parser.s();

        System.out.println(tree.toStringTree(parser));
    }
}
