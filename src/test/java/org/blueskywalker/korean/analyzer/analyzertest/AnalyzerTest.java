package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttributeImpl;
import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.util.Version;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AnalyzerTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testExistingAnalyzer() {

        String field = "test";
        String source = "너무 너무beautiful한 정서적인나무가 아닌가 싶네요.";
        source = "Once you have tests, you'll want to run them.";



        try {
            TestAnalyzer[] analyzers = {
                new TestWhitespaceAnalyzer(field, new StringReader(source)),
                new TestSimpleAnalyzer(field, new StringReader(source)),
                new TestKeywordAnalyzer(field, new StringReader(source)),
                new TestStopwordAnalyzer(field, new StringReader(source)),
                new TestStandardAnalyzer(field, new StringReader(source)),
                //stemmer error            new TestSnowballAnalyzer(field, new StringReader(source))
                new TestICUAnalyzer(field, new StringReader(source)),
                new TestClassicAnalyzer(field, new StringReader(source))
            };

            for (TestAnalyzer analyzer : analyzers) {
                analyzer.analyze();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    @Test
    public void testStandardAnalyzer() {
        String testString = "hello world, welcome to Analyzer world";

        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
        try {
            TokenStream tokenStream = analyzer.tokenStream("test", new StringReader(testString));

            while (tokenStream.incrementToken()) {

                CharTermAttribute term = tokenStream.getAttribute(CharTermAttribute.class);
                PositionIncrementAttribute pos = tokenStream.getAttribute(PositionIncrementAttribute.class);
                OffsetAttribute offset = tokenStream.getAttribute(OffsetAttribute.class);

                System.out.println(term.toString());
                System.out.println(pos.getPositionIncrement());
                System.out.println(String.format("%d:%d", offset.startOffset(), offset.endOffset()));

            }
        } catch (IOException ex) {
            Logger.getLogger(AnalyzerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testTokenizer() {

        String test = "한글이 tokenizing 되어서 나오면 좋지 I am hello.";

        StandardTokenizer tokenizer = new StandardTokenizer(Version.LUCENE_CURRENT, new StringReader(test));
        try {

            while (tokenizer.incrementToken()) {
                if (tokenizer.hasAttributes()) {
                    Iterator<AttributeImpl> iter = tokenizer.getAttributeImplsIterator();
                    while (iter.hasNext()) {
                        AttributeImpl attr = iter.next();
                        // System.out.println(attr.getClass().getName());
                        System.out.println(attr.toString());
                    }
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(AnalyzerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testWhitespaceTokenizer() {
        String testString = "hello world whitespace analyzer";

        WhitespaceTokenizer tokenizer = new WhitespaceTokenizer(Version.LUCENE_CURRENT, new StringReader(testString));

        try {

            while (tokenizer.incrementToken()) {
                if (tokenizer.hasAttributes()) {
                    Iterator<AttributeImpl> iter = tokenizer.getAttributeImplsIterator();
                    while (iter.hasNext()) {
                        AttributeImpl attr = iter.next();
                        // System.out.println(attr.getClass().getName());
                        System.out.println(attr.toString());
                    }
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(AnalyzerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
}
