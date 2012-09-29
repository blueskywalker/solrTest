/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueskywalker.korean.analyzer.analyzertest;

import com.ibm.icu.text.Collator;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;
import org.apache.lucene.collation.ICUCollationKeyAnalyzer;

/**
 *
 * @author blueskywalker
 */

public class TestICUAnalyzer extends TestAnalyzer {

    public TestICUAnalyzer(String field, Reader reader) {
        super(field, reader);
        
        Collator coll = Collator.getInstance();
        
        ICUCollationKeyAnalyzer icu = new ICUCollationKeyAnalyzer(coll);
        
        analyzer = icu;
        tokenStream = analyzer.tokenStream(field, reader);
        token = tokenStream;
        
    }
    @Override
    public void analyze() throws IOException {
        defaultAnalysis();
    }
    
}
