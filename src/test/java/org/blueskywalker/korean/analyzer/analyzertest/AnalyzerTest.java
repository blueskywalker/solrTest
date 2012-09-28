package org.blueskywalker.korean.analyzer.analyzertest;


import java.io.IOException;
import java.io.StringReader;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
        // source = "Once you have tests, you'll want to run them.";


        TestAnalyzer [] analyzers = {
            new TestWhitespaceAnalyzer(field, new StringReader(source)),
            new TestSimpleAnalyzer(field, new StringReader(source)),
            new TestKeywordAnalyzer(field,new StringReader(source)),
            new TestStopwordAnalyzer(field, new StringReader(source))
        };
                
        for(TestAnalyzer analyzer : analyzers) {  
            analyzer.analyze();
        }
        
        assertTrue(true);
    }
}
