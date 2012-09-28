/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import com.ibm.icu.text.Collator;
import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.collation.ICUCollationKeyAnalyzer;

/**
 *
 * @author blueskywalker
 */

public class TestICUAnalyzer extends TestAnalyzer {

    public TestICUAnalyzer(String field, Reader reader) {
        super(field, reader);
        analyzer = new ICUCollationKeyAnalyzer(Collator.getInstance());
        tokenStream = analyzer.tokenStream(field, reader);
        token = tokenStream;
        
    }
    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }
    
}
