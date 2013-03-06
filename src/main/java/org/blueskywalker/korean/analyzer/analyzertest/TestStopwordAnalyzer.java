package org.blueskywalker.korean.analyzer.analyzertest;


import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerry
 */
public class TestStopwordAnalyzer extends TestAnalyzer {
    
    public TestStopwordAnalyzer(String field,Reader reader) throws IOException {
        super(field, reader);
        analyzer = new StandardAnalyzer(version);
        tokenStream = analyzer.tokenStream(field, reader);
        token = new StandardFilter(version, tokenStream);
    }

    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }
}
