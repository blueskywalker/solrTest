package org.blueskywalker.korean.analyzer.analyzertest;

import com.ibm.icu.impl.ICUConfig;
import java.io.IOException;
import java.io.StringReader;
import org.apache.lucene.analysis.icu.segmentation.ICUTokenizer;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AnalyzerTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testExistingAnalyzer() {

        String field = "test";
        String source = "너무 너무beautiful한 정서적인나무가 아닌가 싶네요.";
         source = "Once you have tests, you'll want to run them.";


        TestAnalyzer[] analyzers = {
            new TestWhitespaceAnalyzer(field, new StringReader(source)),
            new TestSimpleAnalyzer(field, new StringReader(source)),
            new TestKeywordAnalyzer(field, new StringReader(source)),
            new TestStopwordAnalyzer(field, new StringReader(source)),
            new TestStandardAnalyzer(field, new StringReader(source)),
            //stemmer error            new TestSnowballAnalyzer(field, new StringReader(source))
            new TestICUAnalyzer(field, new StringReader(source)),
            new TestClassicAnalyzer(field, new StringReader(source))
        };

        try {

            for (TestAnalyzer analyzer : analyzers) {
                analyzer.analyze();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

}
