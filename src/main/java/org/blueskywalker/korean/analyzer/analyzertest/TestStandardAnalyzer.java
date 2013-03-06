/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

/**
 *
 * @author blueskywalker
 */
public class TestStandardAnalyzer  extends TestAnalyzer {
    
    public TestStandardAnalyzer(String field,Reader reader) throws IOException {
        super(field, reader);
        analyzer = new StandardAnalyzer(version);
        tokenStream = analyzer.tokenStream(field, reader);
        token = tokenStream;
    }

    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }
}
