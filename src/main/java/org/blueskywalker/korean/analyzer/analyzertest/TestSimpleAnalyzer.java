/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.core.SimpleAnalyzer;

/**
 *
 * @author jerry
 */
public class TestSimpleAnalyzer extends TestAnalyzer {
    
    public TestSimpleAnalyzer(String field, Reader reader) throws IOException {
        super(field, reader);
        analyzer = new SimpleAnalyzer(version);
        tokenStream = analyzer.tokenStream(field, reader);
        token = tokenStream;        
    }

    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }
            
    
}
