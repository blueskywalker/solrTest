package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.util.Version;

/**
 * TestAnalyzer
 *
 */
public abstract class TestAnalyzer {

    Analyzer analyzer;
    TokenStream tokenStream;
    TokenStream token;
    final static Version version = Version.LUCENE_36;

    /**
     *
     */
    public TestAnalyzer(String field, Reader reader) {
        analyzer = null;
        tokenStream = null;
    }

    abstract public void analyze() throws IOException;
    
    
    void defaultAnalysis() throws IOException {
        
        System.out.println(getClass().getName());
        
        while (token.incrementToken()) {

            CharTermAttribute termAttr = tokenStream.getAttribute(CharTermAttribute.class);
            OffsetAttribute offAttr = tokenStream.getAttribute(OffsetAttribute.class);
            //  PositionIncrementAttribute posAttr = tokenStream.getAttribute(PositionIncrementAttribute.class);
            //  TypeAttribute typeAttr = tokenStream.getAttribute(TypeAttribute.class);

            int len = offAttr.endOffset() - offAttr.startOffset();
            System.out.printf("%d:%d:%s\n", offAttr.startOffset(),
                    offAttr.endOffset(), new String(termAttr.buffer()).substring(0, len));
        }

    }

    public static void main(String[] args) {
        System.out.println(TestAnalyzer.class.getName());
    }
}
