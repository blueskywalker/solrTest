/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;

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
    public TestWhitespaceAnalyzer(String field, Reader reader) throws IOException {
        super(field, reader);
        analyzer = new WhitespaceAnalyzer(version);
        tokenStream = analyzer.tokenStream(field, reader);
        token = tokenStream;
    }

    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }


}
