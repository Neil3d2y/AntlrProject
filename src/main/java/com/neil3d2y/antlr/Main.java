package com.neil3d2y.antlr;

import com.neil3d2y.antlr.expression.AntlrToProgram;
import com.neil3d2y.antlr.expression.ExpressionProcessor;
import com.neil3d2y.antlr.expression.Program;
import com.neil3d2y.antlr.generated.ExprLexer;
import com.neil3d2y.antlr.generated.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main Class of Antlr.");
        if (args.length != 1) {
            System.err.println("Usage: file name.");
            System.exit(1);
        }
        String fileName = args[0];
        ExprParser parser = getParser(fileName);

        // Tell ANTLR to build a parseTree
        // parse from the start symbol
        ParseTree antlrAST = parser.prog();

        // Create a visitor for converting the AST to Program/Expression Objects
        AntlrToProgram antlrToProgram = new AntlrToProgram();
        Program program = antlrToProgram.visit(antlrAST);

        if (!antlrToProgram.semanticErrors.isEmpty()) {
            antlrToProgram.semanticErrors.stream()
                    .forEach(System.out::println);
            return;
        }

        ExpressionProcessor ep = new ExpressionProcessor(program.expressions);
        for (String evaluation : ep.getEvaluationResults()) {
            System.out.println(evaluation);
        }
    }

    /**
     * Lexer and Parser are specific to our g4.
     * @param fileName input
     * @return ExprParser
     */
    private static ExprParser getParser(String fileName) {
        ExprParser parser = null;

        try {
            CharStream input = CharStreams.fromFileName(fileName);
            ExprLexer lexer = new ExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new ExprParser(tokens);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parser;
    }
}
