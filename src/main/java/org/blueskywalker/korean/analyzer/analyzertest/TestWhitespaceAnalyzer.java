/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.Version;

/**
 *
 * @author jerry
 */
public class TestWhitespaceAnalyzer extends TestAnalyzer {

    /**
     *
     * @param field
     * @param reader
     */
    public TestWhitespaceAnalyzer(String field, Reader reader) {
        super(field, reader);
        analyzer = new WhitespaceAnalyzer(version);
        tokenStream = analyzer.tokenStream(field, reader);
        token = tokenStream;
    }

    @Override
    public void analyze() throws IOException {

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
}
