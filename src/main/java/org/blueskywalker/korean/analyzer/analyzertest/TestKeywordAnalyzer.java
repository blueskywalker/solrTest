/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.LowerCaseFilter;

/**
 *
 * @author jerry
 */
public class TestKeywordAnalyzer extends TestAnalyzer {

    public TestKeywordAnalyzer(String field,Reader reder) throws IOException {
        super(field, reder);
        analyzer = new KeywordAnalyzer();
        tokenStream = analyzer.tokenStream(field, reder);
        token = new LowerCaseFilter(version,tokenStream);
    }
    
    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }
    
}
