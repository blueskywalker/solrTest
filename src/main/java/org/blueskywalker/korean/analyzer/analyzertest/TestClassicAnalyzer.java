/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.standard.ClassicAnalyzer;

/**
 *
 * @author blueskywalker
 */
public class TestClassicAnalyzer extends TestAnalyzer {

    public TestClassicAnalyzer(String field,Reader reader) {
        super(field, reader);
        analyzer = new ClassicAnalyzer(version);
        tokenStream = analyzer.tokenStream(field, reader);
        token = tokenStream;
    }
    
    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }
    
    
    
}
