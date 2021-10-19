package com.rayschade;

import com.rayschade.parser.AlgebraLexer;
import com.rayschade.parser.AlgebraParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMethod extends AlgebraHandleMethod {
    private String name = "input";

    public FileMethod(String name) {
        this.name = name;
    }

    public FileMethod() {

    }

    @Override
    protected String collectRawString() throws FileNotFoundException {
        var file = new File(name);
        var builder = new StringBuilder();
        var scan = new Scanner(file);
        while (scan.hasNextLine()) {
            builder.append(scan.nextLine()).append("\n");
        }
        return builder.toString();
    }

    @Override
    protected String parse(String raw) {
        var builder = new StringBuilder();
        var split = raw.split("\n");
        for (var r : split) {
            var lexer = new AlgebraLexer(CharStreams.fromString(r));
            var tokens = new CommonTokenStream(lexer);
            var parser = new AlgebraParser(tokens);
            ParseTree tree = parser.s();
            var evalVisitor = new EvalVisitor();
            var prettyPrintVisitor = new PrettyPrintVisitor();
            builder.append(tree.accept(prettyPrintVisitor))
                    .append("= ")
                    .append(tree.accept(evalVisitor))
                    .append("\n");
        }
        return builder.toString();
    }

    @Override
    protected void handleOutput(String parsed) {
        System.out.println(parsed);
    }
}
