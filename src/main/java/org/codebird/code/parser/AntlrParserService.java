package org.codebird.code.parser;

import org.antlr.v4.java8.Java8Lexer;
import org.antlr.v4.java8.Java8Listener;
import org.antlr.v4.java8.Java8Parser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;

/**
 * @author Sundeep
 */
@Service
public class AntlrParserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AntlrParserService.class);


    public void walkSourceFile(File javaSourceFile, Java8Listener java8Listener) throws IOException {
        Assert.notNull(javaSourceFile);
        Assert.isTrue(javaSourceFile.exists());
        Assert.isTrue(javaSourceFile.isFile());
        Assert.isTrue(javaSourceFile.getName().endsWith(".java"));
        LOGGER.info("About to start walking {}", javaSourceFile.getAbsolutePath());
        ANTLRFileStream antlrFileStream = new ANTLRFileStream(javaSourceFile.getAbsolutePath());
        Java8Lexer java8Lexer = new Java8Lexer(antlrFileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(java8Lexer);
        Java8Parser java8Parser = new Java8Parser(tokenStream);
        ParserRuleContext tree = java8Parser.compilationUnit();

        ParseTreeWalker treeWalker = new ParseTreeWalker();
        java8Parser.addParseListener(java8Listener);
        treeWalker.walk(java8Listener, tree);
    }

}
