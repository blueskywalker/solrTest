/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.snowball.SnowballAnalyzer;

/**
 *
 * @author blueskywalker
 */
public class TestSnowballAnalyzer  extends TestAnalyzer {

    public TestSnowballAnalyzer(String field,Reader reader) throws IOException {
        super(field, reader);
        analyzer =  new SnowballAnalyzer(version, field);
        tokenStream = analyzer.tokenStream(field, reader);
        token = tokenStream;
    }
    
    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }
    
    
    
}
