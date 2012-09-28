package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.StringReader;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.Version;

/**
 * Unit test for simple App.
 */
public class AnalyzerTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AnalyzerTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AnalyzerTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testExistingAnalyzer() throws IOException {

        String field="test";
        String source = "너무 너무beautiful한 정서적인나무가 아닌가 싶네요.";
       // source = "Once you have tests, you'll want to run them. JUnit provides tools to define the suite to be run and to display its results. To run tests and see the results on the console, run this from a Java program";


        TestAnalyzer analyzer = new TestWhitespaceAnalyzer(field, new StringReader(source));
        
        analyzer.analyze();
        
        assertTrue(true);
    }
}
